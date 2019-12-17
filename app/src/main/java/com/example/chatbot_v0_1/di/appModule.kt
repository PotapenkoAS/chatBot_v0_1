package com.example.chatbot_v0_1.di

import com.example.chatbot_v0_1.App
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module { factory { androidApplication() as App } }