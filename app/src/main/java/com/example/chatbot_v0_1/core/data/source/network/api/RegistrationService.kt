package com.example.chatbot_v0_1.core.data.source.network.api

import com.example.chatbot_v0_1.core.data.source.network.response.UserResponse
import com.example.chatbot_v0_1.core.domain.entity.User
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface RegistrationService {

    @POST("/rest/registration")
    fun registration(@Body user: User): Single<UserResponse>

    @GET("/rest/check_login")
    fun checkLogin(login: String): Single<Boolean>
}