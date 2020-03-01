package ru.polydevochka.andreynikolaeproject.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.polydevochka.andreynikolaeproject.R

class ImageAdapter(private val myDataset: Array<Int>) :
    RecyclerView.Adapter<ImageAdapter.MyViewHolder>() {


    class MyViewHolder(val imageView: ImageView) : RecyclerView.ViewHolder(imageView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val imageView = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_layout, parent, false) as ImageView


        return MyViewHolder(imageView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.imageView.setImageResource(myDataset[position])

    }


    override fun getItemCount() = myDataset.size

}


