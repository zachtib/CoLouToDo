package io.github.zachtib.coloutodo.inject

import androidx.room.Room
import io.github.zachtib.coloutodo.data.AppDatabase
import io.github.zachtib.coloutodo.data.TodoService
import io.github.zachtib.coloutodo.ui.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "todo_database").build()
    }

    single { TodoService(get()) }

    viewModel { MainViewModel(get()) }
}
