package com.example.vpbankapp.Utilies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.vpbankapp.BannerEntity.BannerEntity
import com.example.vpbankapp.R
import com.squareup.picasso.Picasso

class ViewPagerAdapter(private val bList:List<BannerEntity>):RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {

    inner class PagerViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        val imageBanner:ImageView = ItemView.findViewById(R.id.img_banner)
    }
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ViewPagerAdapter.PagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_banner,parent,false)
        return PagerViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewPagerAdapter.PagerViewHolder, position: Int) {
        val product = bList[position]
        Picasso.get().load(product.image).into(holder.imageBanner)
    }
    override fun getItemCount(): Int {
        return bList.size
    }
}