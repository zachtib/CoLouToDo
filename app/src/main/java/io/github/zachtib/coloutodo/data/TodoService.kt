package io.github.zachtib.coloutodo.data

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TodoService(db: AppDatabase) {
    private val dao = db.todoDao()

    val allItems by lazy {
        dao.getAllTodos()
    }

    fun createTodo(label: String) = GlobalScope.launch {
        dao.insertTodo(Todo(label = label))
    }

    fun setItemComplete(todo: Todo, complete: Boolean) = GlobalScope.launch {
        val newTodo = todo.copy(isComplete = complete)
        dao.updateTodo(newTodo)
    }

    fun deleteTodo(todo: Todo) = GlobalScope.launch {
        dao.deleteTodo(todo)
    }

}