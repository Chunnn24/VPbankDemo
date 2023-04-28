package com.example.vpbankapp.Utilies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.vpbankapp.NewsEntity.NewsEntity
import com.example.vpbankapp.R
import com.squareup.picasso.Picasso

class AdapterNews(private val nList:List<NewsEntity>):RecyclerView.Adapter<AdapterNews.ViewHolder>() {
    inner class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        val imageView = ItemView.findViewById<ImageView>(R.id.img_News)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var product = nList[position]
        Picasso.get().load(product.image).into(holder.imageView)
    }
}