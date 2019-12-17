package com.example.chatbot_v0_1.di

import com.example.chatbot_v0_1.core.presentation.chat.ChatContract
import com.example.chatbot_v0_1.core.presentation.chat.ChatPresenter
import com.example.chatbot_v0_1.core.presentation.login.LoginContract
import com.example.chatbot_v0_1.core.presentation.login.LoginPresenter
import org.koin.dsl.module

val mvpModule = module {
    factory<LoginContract.Presenter> { LoginPresenter() }
    factory<ChatContract.Presenter> { ChatPresenter() }
}