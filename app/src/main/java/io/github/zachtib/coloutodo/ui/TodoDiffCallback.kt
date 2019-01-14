package io.github.zachtib.coloutodo.ui

import androidx.recyclerview.widget.DiffUtil
import io.github.zachtib.coloutodo.data.Todo

object TodoDiffCallback : DiffUtil.ItemCallback<Todo>() {
    override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return (oldItem.id != null && newItem.id != null && oldItem.id == newItem.id)
    }

    override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem == newItem
    }
}