package io.github.zachtib.coloutodo.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    fun getAllTodos(): LiveData<List<Todo>>

    @Query("SELECT * FROM todo WHERE id = :id")
    fun findTodoById(id: Int): LiveData<Todo>
}