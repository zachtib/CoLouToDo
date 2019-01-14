package io.github.zachtib.coloutodo.ui.todoadapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.zachtib.coloutodo.R
import io.github.zachtib.coloutodo.data.Todo
import io.github.zachtib.coloutodo.extensions.inflate
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoAdapter(
    private val onCheckedListener: (Todo, Boolean) -> Any,
    private val onLongPressListener: (Todo) -> Any
) : ListAdapter<Todo, TodoAdapter.TodoViewHolder>(TodoDiffCallback) {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(todo: Todo, onCheckedListener: (Todo, Boolean) -> Any, onLongPressListener: (Todo) -> Any) {
            itemView.todoCheckBox.apply {
                isChecked = todo.isComplete
                text = todo.label
                setOnCheckedChangeListener { _, isChecked -> onCheckedListener(todo, isChecked) }
                setOnLongClickListener {
                    onLongPressListener(todo)
                    true
                }
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