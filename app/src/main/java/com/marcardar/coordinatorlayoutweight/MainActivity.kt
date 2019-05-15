package com.marcardar.coordinatorlayoutweight

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.*
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        list.adapter = MyAdapter(listOf(
            "These items are",
            "all layout_width=\"match_parent\"",
            "but they certainly aren't laid out that way when",
            "recyclerview layout_width=\"0dp\" weight=\"1\"",
            "for workaround, set coordinatorlayout layout_width=\"match_parent\" but shouldn't need to"
        ))
    }

}

class MyAdapter(private val list: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // create view holder to hold reference
        return object: RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.simple_list_item_1, parent, false)) {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //set values
        (holder.itemView as TextView).text =  list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}