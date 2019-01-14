package io.github.zachtib.coloutodo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val label: String,
    val isComplete: Boolean = false
)