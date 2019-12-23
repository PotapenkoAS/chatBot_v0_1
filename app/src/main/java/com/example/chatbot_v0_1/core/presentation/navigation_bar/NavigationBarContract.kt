package com.example.chatbot_v0_1.core.presentation.navigation_bar

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

class NavigationBarContract {
    interface View : MvpView {
        fun navigateToFeed()
        fun navigateToChat()
        fun navigateToPerson()
    }

    interface Presenter : MvpPresenter<View> {

    }
}