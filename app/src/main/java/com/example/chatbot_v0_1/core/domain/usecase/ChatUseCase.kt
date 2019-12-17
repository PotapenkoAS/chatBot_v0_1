package com.example.chatbot_v0_1.core.domain.usecase


import com.example.chatbot_v0_1.core.data.source.network.response.PostMessageResponse
import com.example.chatbot_v0_1.core.domain.repository.ChatRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.get

class ChatUseCase : KoinComponent {

    fun sendMessageApi(message: String): Single<PostMessageResponse> {
        return get<ChatRepository>().sendMessage(message)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}