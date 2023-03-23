package com.example.kotlin_recyclerview_sponge


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting the array of Strings from XML
        val charStringArray = getResources().getStringArray(R.array.characters)

        //ArrayList of Item objects filled with names and images
        val items: ArrayList<Item> = ArrayList<Item>()
        items.add(Item(charStringArray[0], R.drawable.spongebob))
        items.add(Item(charStringArray[1], R.drawable.patrick))
        items.add(Item(charStringArray[2], R.drawable.sandy))
        items.add(Item(charStringArray[3], R.drawable.squedword))

        //set the layout of the contents, i.e. list of repeating views in the recycler view.
        //without it, RecyclerView will not function i.e. there is no out of the box default.
        listCharacters.setLayoutManager(LinearLayoutManager(this))

        //Pass the items object to the defined adapter class
        val adapter = MyAdapter(items)

        //define the method on the onItemClickListner of the adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity, "The Selected Item is "+position,Toast.LENGTH_SHORT).show()
            }

        })

        //Assign the defined adapter object to the RecyclerView adapter
        listCharacters.adapter = adapter

    }
}