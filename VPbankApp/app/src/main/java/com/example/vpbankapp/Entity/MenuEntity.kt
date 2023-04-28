package com.example.vpbankapp.Entity

import com.google.gson.annotations.SerializedName

class MenuEntity(
    @SerializedName("iconUrl") var iconUrl: String?,
    @SerializedName("name") var name: String?,
    @SerializedName("code") val code: String?,
    @SerializedName("isNew") val isNew: Boolean?
)

