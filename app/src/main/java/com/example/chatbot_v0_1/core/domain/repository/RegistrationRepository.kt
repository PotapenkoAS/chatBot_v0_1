package com.example.chatbot_v0_1.core.domain.repository

import com.example.chatbot_v0_1.core.data.source.network.response.UserResponse
import com.example.chatbot_v0_1.core.domain.entity.User
import io.reactivex.Single
import org.koin.core.KoinComponent

interface RegistrationRepository: KoinComponent {

    fun registration(user: User): Single<UserResponse>

    fun checkLogin(login: String): Single<Boolean>
}