package com.example.pinterestapp

interface PixabayView {
    fun showImages(images: ArrayList<ImageModel>)
    fun showError(error: String)
}