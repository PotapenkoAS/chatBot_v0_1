package com.example.chatbot_v0_1.core.data.repository

import com.example.chatbot_v0_1.core.data.source.network.api.RegistrationService
import com.example.chatbot_v0_1.core.data.source.network.request.RegistrationRequest
import com.example.chatbot_v0_1.core.domain.entity.User
import com.example.chatbot_v0_1.core.domain.repository.RegistrationRepository
import io.reactivex.Single
import org.koin.core.get

class RegistrationRepositoryImpl : RegistrationRepository {
    override fun registration(registrationRequest: RegistrationRequest) =
        get<RegistrationService>().registration(registrationRequest)

    override fun checkLogin(login: String) =
        get<RegistrationService>().checkLogin(login)
}



