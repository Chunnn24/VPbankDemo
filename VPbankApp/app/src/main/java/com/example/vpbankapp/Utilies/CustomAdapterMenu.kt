package com.example.vpbankapp.Utilies


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vpbankapp.Entity.MenuEntity
import com.example.vpbankapp.R
import com.squareup.picasso.Picasso

class CustomAdapterMenu(private val mList:List<MenuEntity>):RecyclerView.Adapter<CustomAdapterMenu.ViewHolder>(){
     inner class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
         val imageView:ImageView = ItemView.findViewById(R.id.img)
         val textView:TextView = ItemView.findViewById(R.id.text)
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = mList[position]

        holder.textView.setText(product.name)
       Picasso.get().load(product.iconUrl).into(holder.imageView)
    }
}