package com.example.chatbot_v0_1.di

import com.example.chatbot_v0_1.core.domain.usecase.ChatUseCase
import com.example.chatbot_v0_1.core.domain.usecase.LoginUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { LoginUseCase() }
    factory { ChatUseCase() }
}