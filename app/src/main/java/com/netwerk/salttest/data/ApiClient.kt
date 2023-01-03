package com.netwerk.salttest.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.netwerk.salttest.data.helper.Constant
import com.netwerk.salttest.data.methods.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private val retrofit: Retrofit

    init {
        var gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val okHttpClientBuilder = OkHttpClient.Builder()
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY}
        okHttpClientBuilder.addNetworkInterceptor { chain ->
            chain.proceed(chain.request()
                .newBuilder()
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36")
                .build())
        }.addNetworkInterceptor(logger)

        val builder = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(okHttpClientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .writeTimeout(0, TimeUnit.MILLISECONDS)
            .writeTimeout(2, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES).build()
        retrofit = builder.client(okHttpClient).build()
    }

    fun service() : Api {
        return retrofit.create(Api::class.java)
    }
}