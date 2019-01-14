package io.github.zachtib.coloutodo.inject

import androidx.room.Room
import io.github.zachtib.coloutodo.data.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val appModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "todo_database").build()
    }
}