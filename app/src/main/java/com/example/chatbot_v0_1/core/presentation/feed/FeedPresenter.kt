package com.example.chatbot_v0_1.core.presentation.feed

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import com.example.chatbot_v0_1.core.domain.entity.FeedItem
import com.example.chatbot_v0_1.core.domain.usecase.FeedUseCase
import com.example.chatbot_v0_1.di.globalContext
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import org.koin.core.KoinComponent
import org.koin.core.inject


class FeedPresenter : KoinComponent,
    MvpBasePresenter<FeedContract.View>(),
    FeedContract.Presenter {

    private val feedUseCase by inject<FeedUseCase>()

    override fun loadFeed() {
        ifViewAttached { view ->
            feedUseCase.doApiFeed()
                .subscribe(
                    { response: ArrayList<FeedItem>? -> processResponse(view, response) },
                    { error: Throwable? -> error?.printStackTrace() }
                )
        }
    }




    private fun processResponse(view: FeedContract.View, response: ArrayList<FeedItem>?) {
        Log.d("SHIT", "gdafjdksafdsafdsafjdsajkfhvdlajfidosalhfid")
        if (response != null)
            view.showNews(response)
    }
}