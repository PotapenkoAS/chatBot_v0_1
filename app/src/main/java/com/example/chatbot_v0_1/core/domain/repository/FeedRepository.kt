package com.example.chatbot_v0_1.core.domain.repository

import com.example.chatbot_v0_1.core.domain.entity.FeedItem
import io.reactivex.Single
import org.koin.core.KoinComponent

interface FeedRepository : KoinComponent {
    fun loadFeed(): Single<ArrayList<FeedItem>>
}