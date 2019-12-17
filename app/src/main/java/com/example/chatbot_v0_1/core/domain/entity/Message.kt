package com.example.chatbot_v0_1.core.domain.entity

import java.util.*
import kotlin.String

data class Message(
    val message: String,
    val dateTime: GregorianCalendar,
    val isMine: Boolean
)