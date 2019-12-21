package com.example.chatbot_v0_1.core.domain.repository

import com.example.chatbot_v0_1.core.data.source.network.request.RegistrationRequest
import com.example.chatbot_v0_1.core.data.source.network.response.UserResponse
import com.example.chatbot_v0_1.core.domain.entity.User
import io.reactivex.Single
import org.koin.core.KoinComponent

interface RegistrationRepository : KoinComponent {

    fun registration(registrationRequest: RegistrationRequest): Single<UserResponse>

    fun checkLogin(login: String): Single<Boolean>
}