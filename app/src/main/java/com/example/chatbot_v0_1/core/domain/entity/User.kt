package com.example.chatbot_v0_1.core.domain.entity

import kotlin.String

data class User(
    val id: Int,
    val login: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val patronymic: String
)