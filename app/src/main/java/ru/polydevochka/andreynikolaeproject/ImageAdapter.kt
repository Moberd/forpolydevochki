package ru.polydevochka.andreynikolaeproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(private val myDataset: Array<Int>) :
    RecyclerView.Adapter<ImageAdapter.MyViewHolder>() {


    class MyViewHolder(val imageView: ImageView) : RecyclerView.ViewHolder(imageView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.MyViewHolder {

        val imageView = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_layout, parent, false) as ImageView


        return MyViewHolder(imageView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.imageView.setImageResource(myDataset[position])

    }


    override fun getItemCount() = myDataset.size

}


