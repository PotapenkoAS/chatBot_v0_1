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
    ): Boolean {
        if (!validator.validateLogin(login)) {
            view.showLoginValidationError()
            return false
        }
        if (!validator.validatePassword(pass1)) {
            view.showPasswordValidationError()
            return false
        }
        if (!validator.validatePasswordMatch(pass1, pass2)) {
            view.showConfirmPasswordValidationError()
            return false
        }
        TempUserStorage.login = login
        TempUserStorage.password = pass1
        return true
    }
}