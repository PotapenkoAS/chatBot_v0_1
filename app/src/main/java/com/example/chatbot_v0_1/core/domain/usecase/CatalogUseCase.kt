package com.example.chatbot_v0_1.core.domain.usecase

import com.example.chatbot_v0_1.core.data.source.network.request.CatalogIdRequest
import com.example.chatbot_v0_1.core.data.source.network.response.CatalogIdResponse
import com.example.chatbot_v0_1.core.domain.repository.CatalogRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.get

class CatalogUseCase : KoinComponent {

    fun doGetCommonInfo(request: CatalogIdRequest): Single<CatalogIdResponse> {
        return get<CatalogRepository>().getCommonInfo(request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}