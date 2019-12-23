package com.example.chatbot_v0_1.core.data.repository

import com.example.chatbot_v0_1.core.data.source.network.api.CatalogService
import com.example.chatbot_v0_1.core.data.source.network.request.CatalogIdRequest
import com.example.chatbot_v0_1.core.data.source.network.response.CatalogIdResponse
import com.example.chatbot_v0_1.core.domain.repository.CatalogRepository
import io.reactivex.Single
import org.koin.core.get

class CatalogRepositoryImpl : CatalogRepository {

    override fun getCommonInfo(request: CatalogIdRequest): Single<CatalogIdResponse> =
        get<CatalogService>().getCommonInfo(request)
}