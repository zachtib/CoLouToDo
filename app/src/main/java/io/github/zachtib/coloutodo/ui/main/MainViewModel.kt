package io.github.zachtib.coloutodo.ui.main

import androidx.lifecycle.ViewModel
import io.github.zachtib.coloutodo.atRandom
import io.github.zachtib.coloutodo.data.TodoService

class MainViewModel(private val service: TodoService) : ViewModel() {

    val allTodoItems = service.allItems

    private val sampleItems = listOf(
        "Clean the kitchen",
        "Take out the Trash",
        "Empty the litter box"
    )

    fun generateSampleData() {
        service.createTodo(sampleItems.atRandom())
    }
}
