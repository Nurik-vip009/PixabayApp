package com.example.pinterestapp

data class PixabayModel(
    var hits: ArrayList<ImageModel>
)

data class ImageModel(
    var largeImageUrl: String
)