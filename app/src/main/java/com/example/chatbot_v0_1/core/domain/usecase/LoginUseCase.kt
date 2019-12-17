package com.example.chatbot_v0_1.core.domain.usecase

import com.example.chatbot_v0_1.core.domain.entity.LoginCredentials
import com.example.chatbot_v0_1.core.domain.repository.LoginRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.get

class LoginUseCase : KoinComponent {

    fun doApiLogin(loginCredentials: LoginCredentials): Single<Boolean> {
        return get<LoginRepository>().login(loginCredentials)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }
}