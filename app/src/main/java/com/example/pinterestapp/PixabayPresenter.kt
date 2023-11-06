package com.example.pinterestapp

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PixabayPresenter(private var view: PixabayView) {

    private val pixabayApi = PixabayApiClient.create()

    /*fun searchImages(apiKey: String, query: String) {
        val call: Call<PixabayApiResponse> = pixabayApi.getImages(apiKey, query)
        call.enqueue(object : Callback<PixabayApiResponse> {
            override fun onResponse(
                call: Call<PixabayApiResponse>,
                response: Response<PixabayApiResponse>
            ) {
                if (response.isSuccessful) {
                    val images = response.body()?.hits ?: emptyList()
                    view.showImages(images)
                } else {
                    view.showError("Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<PixabayApiResponse>, t: Throwable) {
                view.showError("Network error: ${t.message}")
            }
        })
    }*/
    fun searchImages(query: String){
        pixabayApi.getImages(query).enqueue(object :Callback<PixabayModel>{
            override fun onResponse(call: Call<PixabayModel>, response: Response<PixabayModel>) {
                if (response.isSuccessful){
                    Log.e("nurislam", "onResponse: ${response.body()!!.hits}", )
                    view.showImages(response.body()!!.hits)
                }
            }

            override fun onFailure(call: Call<PixabayModel>, t: Throwable) {
                Log.e("nurislam",t.message.toString())
            }

        })
    }
    fun attachView(view: PixabayView){
        this.view = view
    }
}
