package com.example.chatbot_v0_1.core.presentation.registration.steptwo.processor

class StepTwoValidator {

    fun validateLastName(lastName: String): Boolean {
        return lastName.isNotEmpty()
    }

    fun validateFirstName(firstName: String): Boolean {
        return firstName.isNotEmpty()
    }

    fun validateGroup(group: String): Boolean{
        return group.isNotEmpty()
        //todo check with back results OR refactor all to use back response in spinner
    }

}