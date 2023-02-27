package com.example.kotlin_recyclerview_sponge


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting the recyclerview by its id
        val recyclerView = findViewById<RecyclerView>(R.id.listCharacters)
        val charStringArray = getResources().getStringArray(R.array.characters)

        val items: ArrayList<Item> = ArrayList<Item>()
        //val items =  List<Item>
        items.add(Item(charStringArray[0], R.drawable.spongebob))
        items.add(Item(charStringArray[1], R.drawable.patrick))
        items.add(Item(charStringArray[2], R.drawable.sandy))
        items.add(Item(charStringArray[3], R.drawable.squedword))

        recyclerView.setLayoutManager(LinearLayoutManager(this))

        val adapter = MyAdapter(items)
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity, "The Selected Item is "+position,Toast.LENGTH_SHORT).show()
            }

        })

        recyclerView.adapter = adapter

    }
}