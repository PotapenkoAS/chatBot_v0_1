package com.example.chatbot_v0_1.core.domain.entity

import java.sql.Timestamp

data class FeedItem(
    val id: Int,
    val title: String,
    val text: String,
    val dateTime: Timestamp,
    val image: String?
)