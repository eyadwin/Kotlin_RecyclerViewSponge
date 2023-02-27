package com.example.kotlin_recyclerview_sponge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val items: List<Item>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener

    // Declaring the interface in adapter
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    // Function for setting the interface variable
    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }

    // return a viewholder, and inflate the layout we created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false), mListener);
    }
    //set items to the view
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.nameView.setText(items?.get(position)?.getName())
        holder.imageView.setImageResource(items?.get(position)!!.getImage())

    }

    // return count of total items we have created
    override fun getItemCount(): Int {
        return items!!.size
    }

    class MyViewHolder(itemView: View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val nameView: TextView
        val imageView: ImageView

        init {
            // Define click listener for the ViewHolder's View
            nameView = itemView.findViewById(R.id.name)
            imageView = itemView.findViewById(R.id.imageview)

            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }

    }
}