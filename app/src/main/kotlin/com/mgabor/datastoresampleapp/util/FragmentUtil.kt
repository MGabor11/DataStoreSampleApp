package com.mgabor.datastoresampleapp.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope

val Fragment.fragmentScope: LifecycleCoroutineScope
    get() = viewLifecycleOwner.lifecycleScope
