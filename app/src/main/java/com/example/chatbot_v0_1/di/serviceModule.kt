package com.example.chatbot_v0_1.di

import com.example.chatbot_v0_1.BuildConfig
import com.example.chatbot_v0_1.core.NETWORK_BASE_URL
import com.example.chatbot_v0_1.core.NETWORK_TIMEOUT
import com.example.chatbot_v0_1.core.data.source.network.api.ChatService
import com.example.chatbot_v0_1.core.data.source.network.api.FeedService
import com.example.chatbot_v0_1.core.data.source.network.api.LoginService
import com.example.chatbot_v0_1.core.data.source.network.api.RegistrationService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val retrofit = provideRetrofit()

val serviceModule = module {
    single { provideLoginService() }
    single { provideChatService() }
    single { provideRegistrationService() }
    single { provideFeedService() }
}


private fun provideFeedService(): FeedService {
    return retrofit.create(FeedService::class.java)
}

private fun provideLoginService(): LoginService {
    return retrofit.create(LoginService::class.java)
}

private fun provideRegistrationService(): RegistrationService {
    return retrofit.create(RegistrationService::class.java)
}

private fun provideChatService(): ChatService {
    return retrofit.create(ChatService::class.java)
}

private fun provideRetrofit(): Retrofit {
    val loggingInterceptorHeader = HttpLoggingInterceptor()
    val loggingInterceptorBody = HttpLoggingInterceptor()

    loggingInterceptorHeader.level =
        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.HEADERS
        else HttpLoggingInterceptor.Level.NONE

    loggingInterceptorBody.level =
        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE
    val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptorBody)
        .build()

    return Retrofit.Builder()
        .baseUrl(NETWORK_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
}