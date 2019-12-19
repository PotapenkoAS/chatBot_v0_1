package com.example.chatbot_v0_1.core.data.repository

import com.example.chatbot_v0_1.core.data.source.network.api.ChatService
import com.example.chatbot_v0_1.core.domain.repository.ChatRepository
import org.koin.core.get

class ChatRepositoryImpl : ChatRepository {
    override fun sendMessage(message: String) =
        get<ChatService>().postMessage(message)

}