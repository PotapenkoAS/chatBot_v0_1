package com.example.chatbot_v0_1.core.data.repository

import com.example.chatbot_v0_1.core.data.source.network.api.LoginService
import com.example.chatbot_v0_1.core.domain.entity.LoginCredentials
import com.example.chatbot_v0_1.core.domain.repository.LoginRepository
import org.koin.core.get

class LoginRepositoryImpl : LoginRepository {
    override fun login(loginCredentials: LoginCredentials) =
        get<LoginService>().login(loginCredentials)

}