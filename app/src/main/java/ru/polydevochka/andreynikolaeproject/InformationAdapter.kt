package ru.polydevochka.andreynikolaeproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.info_layout.view.*

class InformationAdapter(private val myDataset: Array<Array<String>>) :
    RecyclerView.Adapter<InformationAdapter.MyViewHolder>() {



    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val textType: TextView = view.findViewById(R.id.type)
        val textInfo: TextView = view.findViewById(R.id.info)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {

        val holderView = LayoutInflater.from(parent.context)
            .inflate(R.layout.info_layout, parent, false) as View


        return MyViewHolder(holderView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        holder.textInfo.text = myDataset[position][1]
        holder.textType.text = myDataset[position][0]
    }


    override fun getItemCount() = myDataset.size

}