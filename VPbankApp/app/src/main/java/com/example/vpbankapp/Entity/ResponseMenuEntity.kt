package com.example.vpbankapp.Entity

import com.google.gson.annotations.SerializedName

class ResponseMenuEntity(
    @SerializedName("code") var code    : String?  = null,
    @SerializedName("message") var message : String?  = null,
    @SerializedName("data")
    val data:MenuResponseEntity
    )
