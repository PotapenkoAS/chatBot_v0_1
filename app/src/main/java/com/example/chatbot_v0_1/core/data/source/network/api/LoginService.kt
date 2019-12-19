package com.example.chatbot_v0_1.core.data.source.network.api

import com.example.chatbot_v0_1.core.domain.entity.LoginCredentials
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("/rest/login")
    fun login(@Body loginCredentials: LoginCredentials): Single<Boolean>
}