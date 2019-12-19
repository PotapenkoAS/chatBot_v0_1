package com.example.chatbot_v0_1.core.presentation.registration.stepone

import com.example.chatbot_v0_1.core.presentation.registration.stepone.processor.OnClickProcessor
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import org.koin.core.KoinComponent

class RegistrationStepOnePresenter : KoinComponent,
    MvpBasePresenter<RegistrationStepOneContract.View>(),
    RegistrationStepOneContract.Presenter {

    private val processor = OnClickProcessor()

    override fun processClick(login: String, pass1: String, pass2: String) {
        ifViewAttached { view ->
            processor.process(view, login, pass1, pass2)

        }
    }

}