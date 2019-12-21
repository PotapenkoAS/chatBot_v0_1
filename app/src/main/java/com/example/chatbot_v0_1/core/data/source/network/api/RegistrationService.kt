package com.example.chatbot_v0_1.core.data.source.network.api

import com.example.chatbot_v0_1.core.data.source.network.request.RegistrationRequest
import com.example.chatbot_v0_1.core.data.source.network.response.UserResponse
import com.example.chatbot_v0_1.core.domain.entity.User
import io.reactivex.Single
import retrofit2.http.*


interface RegistrationService {

    @POST("/rest/registration")
    fun registration(@Body registrationRequest: RegistrationRequest): Single<UserResponse>

    @GET("/rest/check_login")
    fun checkLogin(@Query("login") login: String): Single<Boolean>
}