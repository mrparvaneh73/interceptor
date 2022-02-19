package com.example.class281114001

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object NetWorkManager {
     val client by lazy { OkHttpClient.Builder().addInterceptor(getLogInterceptor()).build() }
    private fun getLogInterceptor() : Interceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }
}