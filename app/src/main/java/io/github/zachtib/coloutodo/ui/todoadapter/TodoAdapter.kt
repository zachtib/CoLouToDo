package io.github.zachtib.coloutodo.ui.todoadapter

import android.graphics.Paint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.zachtib.coloutodo.R
import io.github.zachtib.coloutodo.data.Todo
import io.github.zachtib.coloutodo.extensions.inflate
import io.github.zachtib.coloutodo.extensions.onLongClick
import io.github.zachtib.coloutodo.extensions.setStrikethrough
import kotlinx.android.synthetic.main.item_todo.view.*

typealias OnChecked = (Todo, Boolean) -> Any
typealias OnLongPress = suspend (Todo) -> Any

class TodoAdapter(
    private val onCheckedListener: OnChecked,
    private val onLongPressListener: OnLongPress
) : ListAdapter<Todo, TodoAdapter.TodoViewHolder>(TodoDiffCallback) {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(todo: Todo, onCheckedListener: OnChecked, onLongPressListener: OnLongPress) {
            itemView.todoCheckBox.apply {
                isChecked = todo.isComplete
                setOnCheckedChangeListener { _, isChecked -> onCheckedListener(todo, isChecked) }
            }
            itemView.todoLabel.apply {
                text = todo.label
                setStrikethrough(todo.isComplete)
                onLongClick { onLongPressListener(todo) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(parent.inflate(R.layout.item_todo))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position), onCheckedListener, onLongPressListener)
    }

}