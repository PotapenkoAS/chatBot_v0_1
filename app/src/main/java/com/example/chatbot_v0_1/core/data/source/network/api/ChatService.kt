package com.example.chatbot_v0_1.core.data.source.network.api

import com.example.chatbot_v0_1.core.data.source.network.response.PostMessageResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ChatService {

    @Headers("Content-Type: application/json")
    @POST("/rest/message")
    fun postMessage(@Body message: String): Single<PostMessageResponse>
}