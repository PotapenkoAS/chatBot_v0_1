package com.example.chatbot_v0_1.core.data.source.network.response

data class Group(
    var id: Int,
    var shortName: String,
    var fullName: String,
    var number: Int,
    var departmentId: Int
)