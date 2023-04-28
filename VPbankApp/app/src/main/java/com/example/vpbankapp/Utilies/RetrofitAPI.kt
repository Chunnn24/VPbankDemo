package com.example.vpbankapp.Utilies

import com.example.vpbankapp.BannerEntity.ResponseBannerEntity
import com.example.vpbankapp.Entity.ResponseMenuEntity
import com.example.vpbankapp.NewsEntity.ResponseNewsEntity
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {
    @GET("demo/learning/demovpb/vpbmenu.json")
    fun getData(): Call<ResponseMenuEntity>

    @GET("demo/learning/demovpb/vpbpromotion.json")
    fun getNewsPromotion() :Call<ResponseNewsEntity>

    @GET("demo/learning/demovpb/vpbbanner.json")
    fun getBannerLink():Call<ResponseBannerEntity>
}