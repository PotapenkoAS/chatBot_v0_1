package com.example.chatbot_v0_1

import android.app.Application
import com.example.chatbot_v0_1.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {
    private val modulesList = listOf(mvpModule, useCaseModule, appModule, repositoryModule, serviceModule)

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(modulesList)
        }
    }
}