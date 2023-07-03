package com.example.catsdemo.data.utils

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Service {

    fun getRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        val httpClient = OkHttpClient.Builder().addInterceptor { chain ->
            val url = chain
                .request()
                .url
                .newBuilder()
                .addQueryParameter("api-key", Constants.API_KEY)
                .build()
            chain.proceed(chain.request().newBuilder().url(url).build())
        }

        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging).networkInterceptors().add(Interceptor {
            val requestBuilder: Request.Builder = it.request().newBuilder()
            requestBuilder.header(Constants.API_KEY, Constants.BASE_URL)
            it.proceed(requestBuilder.build())
        })

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }

}