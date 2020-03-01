package ru.polydevochka.andreynikolaeproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DatesAdapter(private val myDataset: Array<Array<String>>) :
    RecyclerView.Adapter<DatesAdapter.MyViewHolder>() {



    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val textDate: TextView = view.findViewById(R.id.date)
        val textTime: TextView = view.findViewById(R.id.time)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val holderView = LayoutInflater.from(parent.context)
            .inflate(R.layout.dates_layout, parent, false) as View

        return MyViewHolder(holderView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        holder.textTime.text = myDataset[position][1]
        holder.textDate.text = myDataset[position][0]
    }


    override fun getItemCount() = myDataset.size

}