package com.mgabor.datastoresampleapp.ui.detail.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mgabor.datastoresampleapp.data.User
import com.mgabor.datastoresampleapp.data.UserDataSource

class UserDiffCallback : DiffUtil.ItemCallback<Pair<UserDataSource, User>>() {
    override fun areItemsTheSame(
        oldItem: Pair<UserDataSource, User>,
        newItem: Pair<UserDataSource, User>
    ): Boolean {
        return oldItem.first == newItem.first
    }

    override fun areContentsTheSame(
        oldItem: Pair<UserDataSource, User>,
        newItem: Pair<UserDataSource, User>
    ): Boolean {
        return oldItem.first == newItem.first
    }
}
