package io.github.zachtib.coloutodo.ui.main

import androidx.lifecycle.ViewModel
import io.github.zachtib.coloutodo.data.Todo
import io.github.zachtib.coloutodo.data.TodoService

class MainViewModel(private val service: TodoService) : ViewModel() {

    val allTodoItems = service.allItems

    fun itemChecked(todo: Todo, isChecked: Boolean) {
        service.setItemComplete(todo, isChecked)
    }

    fun newItemCreated(label: String) {
        service.createTodo(label)
    }

    fun deleteItem(todo: Todo) {
        service.deleteTodo(todo)
    }
}
