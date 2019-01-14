package io.github.zachtib.coloutodo.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Todo::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}