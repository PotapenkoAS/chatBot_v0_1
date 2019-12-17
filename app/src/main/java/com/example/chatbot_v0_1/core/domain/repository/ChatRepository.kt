package com.example.chatbot_v0_1.core.domain.repository

import com.example.chatbot_v0_1.core.data.source.network.response.PostMessageResponse
import io.reactivex.Single
import org.koin.core.KoinComponent

interface ChatRepository : KoinComponent {

    fun sendMessage(message: String): Single<PostMessageResponse>
}