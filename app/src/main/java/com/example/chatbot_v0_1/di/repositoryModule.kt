package com.example.chatbot_v0_1.di

import com.example.chatbot_v0_1.core.data.repository.*
import com.example.chatbot_v0_1.core.domain.repository.*
import kotlinx.coroutines.channels.Channel
import org.koin.dsl.module

val repositoryModule = module {
    factory<LoginRepository> { LoginRepositoryImpl() }
    factory<RegistrationRepository> { RegistrationRepositoryImpl() }
    factory<ChatRepository> { ChatRepositoryImpl() }
    factory<FeedRepository> { FeedRepositoryImpl() }
    factory<CatalogRepository> { CatalogRepositoryImpl() }
}