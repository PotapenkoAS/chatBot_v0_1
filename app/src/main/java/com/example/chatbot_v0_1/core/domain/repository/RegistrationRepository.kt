package com.example.chatbot_v0_1.core.domain.repository

import com.example.chatbot_v0_1.core.domain.entity.User
import org.koin.core.KoinComponent

interface RegistrationRepository: KoinComponent {

    fun registration(user: User): Boolean

}