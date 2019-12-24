package com.example.chatbot_v0_1.core.presentation.registration.stepone.processor

import com.example.chatbot_v0_1.core.LOGIN_MIN_LENGTH
import com.example.chatbot_v0_1.core.PASSWORD_MIN_LENGTH

class StepOneValidator {

    fun validatePasswordMatch(pass1: String, pass2: String): Boolean {
        return pass1 == pass2
    }

    fun validateLogin(login: String): Boolean {
        return login.length >= LOGIN_MIN_LENGTH
    }

    fun validatePassword(password: String): Boolean {
        return password.length >= PASSWORD_MIN_LENGTH
    }
}