package com.example.chatbot_v0_1.core.data.source.network.api

import com.example.chatbot_v0_1.core.data.source.network.request.CatalogIdRequest
import com.example.chatbot_v0_1.core.data.source.network.response.CatalogIdResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface CatalogService {

    @POST("/rest/catalog/common")
    fun getCommonInfo(@Body request: CatalogIdRequest): Single<CatalogIdResponse>
}