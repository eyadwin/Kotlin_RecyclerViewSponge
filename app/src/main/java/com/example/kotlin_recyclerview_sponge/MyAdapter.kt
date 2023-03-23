package com.example.kotlin_recyclerview_sponge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//We must implement three methods of the RecyclerView.Adapter
//1- onCreateViewHolder
//2- onBindViewHolder
//3- getItemCount
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
    //only creates a new view holder when there are no existing view holders which the RecyclerView can reuse.
    // So, for instance, if your RecyclerView can display 5 items at a time, it will create 5-6 ViewHolders,
    // and then automatically reuse them, each time calling onBindViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false), mListener);
    }
    //set items to the view
    //Note that instead of creating new view for each new row, an old view is recycled and reused by binding new data to it.
    //Initially you will get new unused view holders and you have to fill them with data you want to display.
    // But as you scroll you'll start getting view holders that were used for rows that went off screen
    // and you have to replace old data that they held with new data.
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.nameView.setText(items.get(position).getName())
        holder.imageView.setImageResource(items.get(position).getImage())
    }

    //It returns The number of items currently available in adapter.
    override fun getItemCount(): Int {
        return items.size
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