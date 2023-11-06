package com.example.pinterestapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PixabayApiClient {

        private const val BASE_URL = "https://pixabay.com"

        fun create(): PixabayApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(PixabayApi::class.java)
        }
    }
