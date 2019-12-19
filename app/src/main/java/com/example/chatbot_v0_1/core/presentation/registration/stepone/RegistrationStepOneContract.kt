package com.example.chatbot_v0_1.core.presentation.registration.stepone

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

class RegistrationStepOneContract {
    interface View : MvpView {
        fun navigateToStepTwo()
        fun showLoginValidationError()
        fun hideLoginValidationError()
        fun showPasswordValidationError()
        fun hidePasswordValidationError()
        fun showConfirmPasswordValidationError()
        fun hideConfirmPasswordValidationError()
    }

    interface Presenter : MvpPresenter<View> {
        fun processClick(login: String, pass1: String, pass2: String)
    }
}