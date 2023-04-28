package com.example.vpbankapp.NewsEntity

import com.google.gson.annotations.SerializedName

class NewsResponseEntity(
    @SerializedName("promotion") var promotion:ArrayList<NewsEntity> = arrayListOf()
)