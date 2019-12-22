package com.example.chatbot_v0_1.core.domain.usecase

import com.example.chatbot_v0_1.core.domain.entity.FeedItem
import com.example.chatbot_v0_1.core.domain.repository.FeedRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.get

class FeedUseCase : KoinComponent {

    fun doApiFeed(): Single<ArrayList<FeedItem>> {
        return get<FeedRepository>().loadFeed()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}