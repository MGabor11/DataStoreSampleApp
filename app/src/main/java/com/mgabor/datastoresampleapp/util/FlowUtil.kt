package com.mgabor.coroutine.util

import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.asLiveData
import com.mgabor.datastoresampleapp.util.launchOnDefault
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flattenMerge
import kotlinx.coroutines.flow.flow

fun <T> Flow<T>.repeatWhenEmits(repeat: Flow<*>) = flow {
    collect { emit(it) }
    repeat.collect {
        collect { emit(it) }
    }
}

fun <T> flowOf(factory: () -> T): Flow<T> = flow {
    emit(factory())
}

@Suppress("SpreadOperator")
fun <T> merge(vararg flows: Flow<T>): Flow<T> = kotlinx.coroutines.flow.flowOf(*flows).flattenMerge()

fun <T> Flow<T>.launchWhenStartedIn(scope: LifecycleCoroutineScope): Job = scope.launchWhenStarted {
    collect() // tail-call
}

fun <T> Flow<T>.launchWhenResumedIn(scope: LifecycleCoroutineScope): Job = scope.launchWhenResumed {
    collect() // tail-call
}

fun <T> Flow<T>.launchOnDefaultIn(scope: CoroutineScope): Job = scope.launchOnDefault {
    collect() // tail-call
}

fun <T> Flow<T>.asLiveDataOnDefault() = asLiveData(Dispatchers.Default)
