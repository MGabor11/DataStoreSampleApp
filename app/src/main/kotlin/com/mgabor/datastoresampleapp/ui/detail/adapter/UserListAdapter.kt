package com.mgabor.datastoresampleapp.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mgabor.datastoresampleapp.R
import com.mgabor.datastoresampleapp.data.User
import com.mgabor.datastoresampleapp.data.UserDataSource
import com.mgabor.datastoresampleapp.databinding.ItemUserBinding

class UserListAdapter : ListAdapter<Pair<UserDataSource, User>, RecyclerView.ViewHolder>(UserDiffCallback()) {

    inner class ViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemUserBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_user,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder: ViewHolder = holder as ViewHolder
        viewHolder.binding.firstName = getItem(position).second.firstName
        viewHolder.binding.lastName = getItem(position).second.lastName
        viewHolder.binding.birthDay = getItem(position).second.birthDay
        viewHolder.binding.typeName = getItem(position).first.name
    }
}
