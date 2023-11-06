package com.example.pinterestapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    //https://pixabay.com/api/?key=25007027-7418deb977c638792f4bfb99f&q=car
    @GET("/api/")
    fun getImages(
        @Query("q") query: String,
        @Query("key") key: String = "25007027-7418deb977c638792f4bfb99f"
    ): Call<PixabayModel>
}