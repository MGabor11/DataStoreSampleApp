package com.mgabor.datastoresampleapp.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Date

@BindingAdapter(value = ["layoutManager", "list"], requireAll = false)
fun <T> RecyclerView.bindRecyclerViewData(
    layoutManager: RecyclerView.LayoutManager?,
    list: List<T>?
) {
    setLayoutManager(layoutManager ?: LinearLayoutManager(this@bindRecyclerViewData.context))
    (adapter as? ListAdapter<T, *>)?.submitList(list)
}

@BindingAdapter("birthDay")
fun TextView.bindBirthDay(birthDay: Long) {
    val simpleDateFormat = SimpleDateFormat("EEEE, dd-MMM-yyyy")
    val dateTime = simpleDateFormat.format(Date(birthDay))

    text = dateTime
}
