package com.example.chatbot_v0_1.di

import com.example.chatbot_v0_1.core.data.repository.ChatRepositoryImpl
import com.example.chatbot_v0_1.core.data.repository.LoginRepositoryImpl
import com.example.chatbot_v0_1.core.data.repository.RegistrationRepositoryImpl
import com.example.chatbot_v0_1.core.domain.repository.ChatRepository
import com.example.chatbot_v0_1.core.domain.repository.LoginRepository
import com.example.chatbot_v0_1.core.domain.repository.RegistrationRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<LoginRepository> { LoginRepositoryImpl() }
    factory<RegistrationRepository> { RegistrationRepositoryImpl() }
    factory<ChatRepository> { ChatRepositoryImpl() }
}