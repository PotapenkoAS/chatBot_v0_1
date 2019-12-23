package com.example.chatbot_v0_1.core.domain.repository

import com.example.chatbot_v0_1.core.data.source.network.request.CatalogIdRequest
import com.example.chatbot_v0_1.core.data.source.network.response.CatalogIdResponse
import io.reactivex.Single
import org.koin.core.KoinComponent

interface CatalogRepository : KoinComponent{

    fun getCommonInfo(request: CatalogIdRequest): Single<CatalogIdResponse>
}