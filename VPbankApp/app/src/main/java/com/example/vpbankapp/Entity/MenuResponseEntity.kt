package com.example.vpbankapp.Entity

import com.google.gson.annotations.SerializedName

class MenuResponseEntity(
    @SerializedName("list_menu" ) var list_menu : ArrayList<MenuEntity> = arrayListOf(),
)