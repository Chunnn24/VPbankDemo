package com.example.vpbankapp

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.vpbankapp.BannerEntity.BannerEntity
import com.example.vpbankapp.BannerEntity.ResponseBannerEntity
import com.example.vpbankapp.Entity.MenuEntity
import com.example.vpbankapp.Entity.ResponseMenuEntity
import com.example.vpbankapp.NewsEntity.NewsEntity
import com.example.vpbankapp.NewsEntity.ResponseNewsEntity
import com.example.vpbankapp.Utilies.AdapterNews
import com.example.vpbankapp.Utilies.CustomAdapterMenu
import com.example.vpbankapp.Utilies.RetrofitAPI
import com.example.vpbankapp.Utilies.RetrofitMenuEntity
import com.example.vpbankapp.Utilies.ViewPagerAdapter
import com.example.vpbankapp.databinding.ActivityAfterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var binding: ActivityAfterBinding
class ActivityAfter : AppCompatActivity() {
    var data = ArrayList<MenuEntity>()
    var banner = ArrayList<BannerEntity>()
    var News = ArrayList<NewsEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAfterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.RcMenu.layoutManager = LinearLayoutManager(this)
        getMenu()
        getBanner()
        getNews()

    }
    private fun getNews() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please wait while data is fetch")
        progressDialog.show()
        val retrofit = RetrofitMenuEntity.buildService(RetrofitAPI::class.java)
        retrofit.getNewsPromotion().enqueue(object : Callback<ResponseNewsEntity> {
            override fun onResponse(
                call: Call<ResponseNewsEntity>,
                response: Response<ResponseNewsEntity>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()!!
                    News = responseBody.data.promotion
                    var adapter = AdapterNews(News)
                    binding.RcNews.adapter = adapter
                    binding.RcNews.layoutManager = GridLayoutManager(
                        this@ActivityAfter,
                        2, GridLayoutManager.VERTICAL, false
                    )
                }
                progressDialog.dismiss()
            }

            override fun onFailure(call: Call<ResponseNewsEntity>, t: Throwable) {
                progressDialog.dismiss()
            }
        })
    }

    private fun getBanner() {
        val retrofit = RetrofitMenuEntity.buildService(RetrofitAPI::class.java)
        retrofit.getBannerLink().enqueue(object : Callback<ResponseBannerEntity> {
            override fun onResponse(
                call: Call<ResponseBannerEntity>,
                response: Response<ResponseBannerEntity>
            ) {
                if (response.isSuccessful) {
                    Log.wtf("0000","Hereeee")
                    val responseBody = response.body()!!
                    banner = responseBody.list_banner.arr
                    val adapter = ViewPagerAdapter(banner)
                    binding.viewPager.adapter = adapter

                    binding.viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
                        override fun onPageScrolled(
                            position: Int,
                            positionOffset: Float,
                            positionOffsetPixels: Int
                        ) {
                            super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                        }
                        override fun onPageSelected(position: Int) {
                            super.onPageSelected(position)
                        }
                        override fun onPageScrollStateChanged(state: Int) {
                            super.onPageScrollStateChanged(state)
                        }
                    })
                }
            }
            override fun onFailure(call: Call<ResponseBannerEntity>, t: Throwable) {
                Log.wtf("0000","false")
            }
        })
    }

    private fun getMenu() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please wait while data is fetch")
        progressDialog.show()
        val retrofit = RetrofitMenuEntity.buildService(RetrofitAPI::class.java)
        retrofit.getData().enqueue(object : Callback<ResponseMenuEntity> {
            override fun onResponse(
                call: Call<ResponseMenuEntity>,
                response: Response<ResponseMenuEntity>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()!!
                    data = responseBody.data.list_menu
                    var adapter = CustomAdapterMenu(data)
                    binding.RcMenu.adapter = adapter
                    binding.RcMenu.layoutManager = GridLayoutManager(
                        this@ActivityAfter,
                        2, GridLayoutManager.HORIZONTAL, false
                    )
                }
                progressDialog.dismiss()
            }
            override fun onFailure(call: Call<ResponseMenuEntity>, t: Throwable) {
                progressDialog.dismiss()
            }
        })
    }
}