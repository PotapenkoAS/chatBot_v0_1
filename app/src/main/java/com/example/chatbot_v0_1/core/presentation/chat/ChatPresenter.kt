package com.example.chatbot_v0_1.core.presentation.chat

import android.util.Log
import com.example.chatbot_v0_1.core.data.source.network.response.PostMessageResponse
import com.example.chatbot_v0_1.core.domain.usecase.ChatUseCase
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import org.koin.core.KoinComponent
import org.koin.core.get

class ChatPresenter : KoinComponent, MvpBasePresenter<ChatContract.View>(), ChatContract.Presenter {

    override fun sendMessage(messageText: String) {
        ifViewAttached { view ->
            view.clearText()
            view.showMyNewMessage(messageText)
            get<ChatUseCase>().sendMessageApi(messageText)
                .subscribe(
                    { response: PostMessageResponse? ->
                        processMessageResponse(
                            response,
                            view,
                            messageText
                        )
                    },
                    { error: Throwable? -> error?.printStackTrace() }
                )
        }
    }


    private fun processMessageResponse(
        response: PostMessageResponse?,
        view: ChatContract.View,
        messageText: String
    ) {
        Log.d("SHIT", response.toString())
        if (response != null) {
            view.showBotNewMessage(response.message)
        }
    }
}
