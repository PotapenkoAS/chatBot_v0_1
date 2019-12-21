package com.example.chatbot_v0_1.core.domain.usecase

import com.example.chatbot_v0_1.core.data.source.network.request.RegistrationRequest
import com.example.chatbot_v0_1.core.data.source.network.response.UserResponse
import com.example.chatbot_v0_1.core.domain.entity.User
import com.example.chatbot_v0_1.core.domain.repository.RegistrationRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.get

class RegistrationUseCase : KoinComponent {

    fun doApiRegistration(registrationRequest: RegistrationRequest): Single<UserResponse> {
        return get<RegistrationRepository>().registration(registrationRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun doApiCheckLogin(login: String): Single<Boolean> {
        return get<RegistrationRepository>().checkLogin(login)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}