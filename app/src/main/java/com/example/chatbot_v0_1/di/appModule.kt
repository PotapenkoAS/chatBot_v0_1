package com.example.chatbot_v0_1.di

import android.content.Context
import com.example.chatbot_v0_1.App
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

val appModule = module { factory { androidApplication() as App } }
val globalContext: Context
    get() = GlobalContext.get().koin.rootScope.androidContext()