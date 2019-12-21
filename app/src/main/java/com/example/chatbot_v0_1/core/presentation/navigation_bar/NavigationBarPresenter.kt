package com.example.chatbot_v0_1.core.presentation.navigation_bar

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import org.koin.core.KoinComponent

class NavigationBarPresenter : KoinComponent,
    MvpBasePresenter<NavigationBarContract.View>(),
    NavigationBarContract.Presenter {
}