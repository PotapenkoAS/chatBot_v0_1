package com.example.chatbot_v0_1.core.data.source.network.api

import com.example.chatbot_v0_1.core.domain.entity.User
import retrofit2.http.POST

interface RegistrationService {

    @POST("/rest/registration")
    fun registration(user: User): Boolean
}