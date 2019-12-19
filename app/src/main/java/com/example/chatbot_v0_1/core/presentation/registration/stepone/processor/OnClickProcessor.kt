package com.example.chatbot_v0_1.core.presentation.registration.stepone.processor

import com.example.chatbot_v0_1.core.domain.entity.TempUserStorage
import com.example.chatbot_v0_1.core.presentation.registration.stepone.RegistrationStepOneContract

class OnClickProcessor {

    private val validator = StepOneValidator()

    fun process(
        view: RegistrationStepOneContract.View,
        login: String,
        pass1: String,
        pass2: String
    ) {
        if (!validator.validateLogin(login)) {
            view.showLoginValidationError()
            return
        }
        if (!validator.validatePassword(pass1)) {
            view.showPasswordValidationError()
            return
        }
        if (!validator.validatePasswordMatch(pass1, pass2)) {
            view.showConfirmPasswordValidationError()
            return
        }
        TempUserStorage.login = login
        TempUserStorage.password = pass1
        view.navigateToStepTwo()
    }
}