package com.example.vpbankapp.BannerEntity

import com.google.gson.annotations.SerializedName

class BannerEntity(
    @SerializedName("image") var image: String?,
    @SerializedName("link") val link: String?
)