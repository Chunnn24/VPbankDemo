package com.example.vpbankapp.BannerEntity

import com.example.vpbankapp.BannerEntity.BannerEntity
import com.google.gson.annotations.SerializedName

class BannerResponseEntity(
    @SerializedName("arr") val arr:ArrayList<BannerEntity> = arrayListOf()
)