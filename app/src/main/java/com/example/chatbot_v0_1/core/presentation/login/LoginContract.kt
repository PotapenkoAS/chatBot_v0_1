package com.example.chatbot_v0_1.core.presentation.login

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

class LoginContract {
    interface View : MvpView {
        fun navigateToChat()
        fun navigateToRegistration()
    }

    interface Presenter : MvpPresenter<View> {
        fun login(login: String, password: String)
        fun autoLogin(deviceId: String)
    }
}