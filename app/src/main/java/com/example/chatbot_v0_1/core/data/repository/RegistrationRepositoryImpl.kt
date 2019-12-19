package com.example.chatbot_v0_1.core.data.repository

import com.example.chatbot_v0_1.core.data.source.network.api.RegistrationService
import com.example.chatbot_v0_1.core.domain.entity.User
import com.example.chatbot_v0_1.core.domain.repository.RegistrationRepository
import io.reactivex.Single
import org.koin.core.get

class RegistrationRepositoryImpl : RegistrationRepository {
    override fun registration(user: User) =
        get<RegistrationService>().registration(user)

    override fun checkLogin(login: String): Single<Boolean> {
        get<RegistrationService>().checkLogin(login)
    }
}



