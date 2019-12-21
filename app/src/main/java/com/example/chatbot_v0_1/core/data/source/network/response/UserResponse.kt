package com.example.chatbot_v0_1.core.data.source.network.response

data class UserResponse(
    val id: Int,
    val login: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val patronymic: String,
    val groupId: Int,
    val instituteId: Int,
    val departmentId: Int,
    val userId: Int
)