package com.example.chatbot_v0_1.core.presentation.chat

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

class ChatContract {

    interface View : MvpView {
        fun showMyNewMessage(messageText: String)
        fun showBotNewMessage(messageText: String)
        fun navigateToFeed()
        fun clearText()
    }

    interface Presenter : MvpPresenter<View> {
        fun sendMessage(messageText: String)
    }
}