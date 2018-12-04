package com.example.windows.desafioprova2.scenarios

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.windows.desafioprova2.R
import com.example.windows.desafioprova2.entities.Drink
import kotlinx.android.synthetic.main.drink_item.view.*


class DrinkAdapter (val context: Context, val drinks: List<Drink>)
    : RecyclerView.Adapter<DrinkAdapter.ViewHolder>(){

    var itemClickListener: ((index: Int) -> Unit)? = null

    fun setOnItemClickListener(clique: ((index: Int) -> Unit)){
        this.itemClickListener = clique
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.drink_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return drinks.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindView(context, drinks[p1], itemClickListener)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindView(context: Context, drink: Drink, itemClickListener: ((index: Int) -> Unit)?){
            itemView.tv_nomedrink.text = drink.strDrink

            if(itemClickListener != null) {
                itemView.setOnClickListener {
                    itemClickListener.invoke(adapterPosition)
                }
            }

            Glide.with(context)
                    .load(drink.strDrinkThumb)
                    .apply(RequestOptions()
                            .placeholder(R.mipmap.back))
                    .into(itemView.tv_imagedrink)
        }
    }
}