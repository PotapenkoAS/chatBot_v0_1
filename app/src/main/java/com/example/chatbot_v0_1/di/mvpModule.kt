package com.example.chatbot_v0_1.di

import com.example.chatbot_v0_1.core.presentation.chat.ChatContract
import com.example.chatbot_v0_1.core.presentation.chat.ChatPresenter
import com.example.chatbot_v0_1.core.presentation.feed.FeedContract
import com.example.chatbot_v0_1.core.presentation.feed.FeedPresenter
import com.example.chatbot_v0_1.core.presentation.login.LoginContract
import com.example.chatbot_v0_1.core.presentation.login.LoginPresenter
import com.example.chatbot_v0_1.core.presentation.navigation_bar.NavigationBarContract
import com.example.chatbot_v0_1.core.presentation.navigation_bar.NavigationBarPresenter
import com.example.chatbot_v0_1.core.presentation.person.PersonContract
import com.example.chatbot_v0_1.core.presentation.person.PersonPresenter
import com.example.chatbot_v0_1.core.presentation.registration.stepone.RegistrationStepOnePresenter
import com.example.chatbot_v0_1.core.presentation.registration.stepone.RegistrationStepOneContract
import com.example.chatbot_v0_1.core.presentation.registration.steptwo.RegistrationStepTwoContract
import com.example.chatbot_v0_1.core.presentation.registration.steptwo.RegistrationStepTwoPresenter
import org.koin.dsl.module

val mvpModule = module {
    factory<LoginContract.Presenter> { LoginPresenter() }
    factory<ChatContract.Presenter> { ChatPresenter() }
    factory<RegistrationStepOneContract.Presenter> { RegistrationStepOnePresenter() }
    factory<RegistrationStepTwoContract.Presenter> { RegistrationStepTwoPresenter() }
    factory<NavigationBarContract.Presenter> { NavigationBarPresenter() }
    factory<FeedContract.Presenter> { FeedPresenter() }
    factory<PersonContract.Presenter> { PersonPresenter() }
}