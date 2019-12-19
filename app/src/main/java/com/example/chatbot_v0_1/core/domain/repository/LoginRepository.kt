package com.example.chatbot_v0_1.core.domain.repository

import com.example.chatbot_v0_1.core.domain.entity.LoginCredentials
import io.reactivex.Single
import org.koin.core.KoinComponent

interface LoginRepository : KoinComponent {

    fun login(loginCredentials: LoginCredentials): Single<Boolean>
}