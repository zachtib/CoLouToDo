package io.github.zachtib.coloutodo

import android.app.Application
import org.koin.android.ext.android.startKoin

class CoLouToDoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf())
    }
}
