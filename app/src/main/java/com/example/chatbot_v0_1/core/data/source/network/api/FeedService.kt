package com.example.chatbot_v0_1.core.data.source.network.api

import com.example.chatbot_v0_1.core.domain.entity.FeedItem
import io.reactivex.Single
import retrofit2.http.GET

interface FeedService {

    @GET("/rest/feed")
    fun loadFeed(): Single<ArrayList<FeedItem>>
}