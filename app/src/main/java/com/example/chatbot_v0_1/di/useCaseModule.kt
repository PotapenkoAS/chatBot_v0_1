package com.example.chatbot_v0_1.di

import com.example.chatbot_v0_1.core.domain.usecase.ChatUseCase
import com.example.chatbot_v0_1.core.domain.usecase.FeedUseCase
import com.example.chatbot_v0_1.core.domain.usecase.LoginUseCase
import com.example.chatbot_v0_1.core.domain.usecase.RegistrationUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { LoginUseCase() }
    factory { RegistrationUseCase() }
    factory { ChatUseCase() }
    factory { FeedUseCase() }
}