package com.team.domain.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private val logging = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val retrofit =
        Retrofit.Builder()
            .baseUrl("http://auradev.mayabiorobotics.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
}