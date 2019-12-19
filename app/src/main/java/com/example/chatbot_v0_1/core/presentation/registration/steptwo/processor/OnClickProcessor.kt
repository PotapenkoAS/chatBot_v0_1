package com.example.chatbot_v0_1.core.presentation.registration.steptwo.processor

import com.example.chatbot_v0_1.core.presentation.registration.steptwo.RegistrationStepTwoContract

class OnClickProcessor {

    private val validator = StepTwoValidator()

    fun process(
        view: RegistrationStepTwoContract.View,
        firstName: String,
        lastName: String,
        patronymic: String,
        group: String
    ): Boolean {
        if (validator.validateFirstName(firstName) && validator.validateLastName(lastName)) {
            return true
        }
        view.showError()
        return false
    }
}