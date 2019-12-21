package com.example.chatbot_v0_1.core.presentation.navigation_bar

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import org.koin.core.KoinComponent

class NavigationBarContract {
    interface View : MvpView {

    }

    interface Presenter : MvpPresenter<View> {

    }
}