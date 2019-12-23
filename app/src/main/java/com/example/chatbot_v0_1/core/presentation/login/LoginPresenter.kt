package com.example.chatbot_v0_1.core.presentation.login

import com.example.chatbot_v0_1.core.data.source.network.request.DeviceIdRequest
import com.example.chatbot_v0_1.core.data.source.network.response.UserResponse
import com.example.chatbot_v0_1.core.domain.entity.LoginCredentials
import com.example.chatbot_v0_1.core.domain.entity.TempUserStorage
import com.example.chatbot_v0_1.core.domain.usecase.LoginUseCase
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import org.json.JSONStringer
import org.koin.core.KoinComponent
import org.koin.core.inject

class LoginPresenter : KoinComponent,
    MvpBasePresenter<LoginContract.View>(),
    LoginContract.Presenter {

    private val loginUseCase by inject<LoginUseCase>()

    override fun login(login: String, password: String) {
        ifViewAttached { view: LoginContract.View ->
            loginUseCase.doApiLogin(LoginCredentials(login, password, TempUserStorage.deviceId!!))
                .subscribe(
                    { response: UserResponse? -> processLoginResponse(response, view) },
                    { error: Throwable? -> error?.printStackTrace() }
                )

        }
    }

    override fun autoLogin(deviceId: String) {
        ifViewAttached { view: LoginContract.View ->
            val request = DeviceIdRequest(deviceId)
            loginUseCase.doApiAutoLogin(request)
                .subscribe(
                    { response: UserResponse? -> processAutoLoginResponse(response, view) },
                    { error: Throwable? -> error?.printStackTrace() })
        }
    }

    private fun processLoginResponse(response: UserResponse?, view: LoginContract.View) {
        if (response != null) {
            println("successful login, server returned $response")
            mapResponseToTempStorage(response)
            view.navigateToFeed()

        } else {
            println("login failed, server returned $response")
        }
    }

    private fun processAutoLoginResponse(response: UserResponse?, view: LoginContract.View) {
        if (response != null) {
            mapResponseToTempStorage(response)
            view.navigateToFeed()
        }
    }

    private fun mapResponseToTempStorage(response: UserResponse) {
        TempUserStorage.id = response.userId
        TempUserStorage.login = response.login
        TempUserStorage.password = response.login
        TempUserStorage.firstName = response.firstName
        TempUserStorage.lastName = response.lastName
        TempUserStorage.patronymic = response.patronymic
        TempUserStorage.groupId = response.groupId
        TempUserStorage.departmentId = response.departmentId
        TempUserStorage.instituteId = response.instituteId
    }
}