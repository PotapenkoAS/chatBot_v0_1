package com.example.chatbot_v0_1.core.presentation.registration.steptwo

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

class RegistrationStepTwoContract {
    interface View : MvpView {
        fun navigateToFeed()
        fun navigateToChat()
        fun showError()
        fun hideError()
    }

    interface Presenter : MvpPresenter<View> {
        fun process(
            firstName: String,
            lastName: String,
            patronymic: String,
            groupShortName: String
        )
    }
}