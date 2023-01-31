package com.example.dontlate

import android.database.sqlite.SQLiteDatabase
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HomeListAdapter(private val itemList : List<home_board>) : RecyclerView.Adapter<ViewHolder_home>() {

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder_home {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false)
        return ViewHolder_home(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder_home, position: Int) {
        val item = itemList[position]
        holder.apply {
            bind(item)
        }
    }
}