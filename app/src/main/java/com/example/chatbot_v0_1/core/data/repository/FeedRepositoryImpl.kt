package com.example.chatbot_v0_1.core.data.repository

import com.example.chatbot_v0_1.core.data.source.network.api.FeedService
import com.example.chatbot_v0_1.core.domain.entity.FeedItem
import com.example.chatbot_v0_1.core.domain.repository.FeedRepository
import io.reactivex.Single
import org.koin.core.get


class FeedRepositoryImpl : FeedRepository {
    override fun loadFeed(): Single<ArrayList<FeedItem>> = get<FeedService>().loadFeed()
}