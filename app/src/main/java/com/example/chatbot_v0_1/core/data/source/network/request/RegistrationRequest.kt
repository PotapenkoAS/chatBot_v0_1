package com.example.chatbot_v0_1.core.data.source.network.request

import com.example.chatbot_v0_1.core.domain.entity.User

class RegistrationRequest(val user: User, val deviceId: String) {
}