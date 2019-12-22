package com.example.chatbot_v0_1.core.presentation.feed

import com.example.chatbot_v0_1.core.domain.entity.FeedItem
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

class FeedContract {
    interface View : MvpView {
        fun showNews(items: ArrayList<FeedItem>)
    }

    interface Presenter : MvpPresenter<View> {
        fun loadFeed()
    }
}