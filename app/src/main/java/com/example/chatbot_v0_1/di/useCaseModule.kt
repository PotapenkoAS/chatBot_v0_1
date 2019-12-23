package com.example.chatbot_v0_1.di

import com.example.chatbot_v0_1.core.domain.usecase.*
import org.koin.dsl.module

val useCaseModule = module {
    factory { LoginUseCase() }
    factory { RegistrationUseCase() }
    factory { ChatUseCase() }
    factory { FeedUseCase() }
    factory { CatalogUseCase() }
}