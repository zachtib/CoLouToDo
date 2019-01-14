package io.github.zachtib.coloutodo.data

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TodoService(db: AppDatabase) {
    private val dao = db.todoDao()

    val allItems by lazy {
        dao.getAllTodos()
    }

    fun createTodo(label: String) {
        GlobalScope.launch {
            dao.insertTodo(Todo(label = label))
        }
    }

}