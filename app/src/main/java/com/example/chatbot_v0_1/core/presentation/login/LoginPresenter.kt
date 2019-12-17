package com.example.chatbot_v0_1.core.presentation.login

import com.example.chatbot_v0_1.core.domain.entity.LoginCredentials
import com.example.chatbot_v0_1.core.domain.usecase.LoginUseCase
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import org.koin.core.KoinComponent
import org.koin.core.inject

class LoginPresenter : KoinComponent,
    MvpBasePresenter<LoginContract.View>(),
    LoginContract.Presenter {

    private val loginUseCase by inject<LoginUseCase>()

    override fun login(login: String, password: String) {
        ifViewAttached { view: LoginContract.View ->
            loginUseCase.doApiLogin(LoginCredentials(login, password))
                .subscribe(
                    { response: Boolean? -> processResponse(response, view) },
                    { error: Throwable? -> error?.printStackTrace() }
                )
        }
    }

    private fun processResponse(response: Boolean?, view: LoginContract.View) {
        if (response != null && response) {
            println("successful login, server returned $response")
            view.navigateToChat()

        } else {
            println("login failed, server returned $response")
        }

    }
}