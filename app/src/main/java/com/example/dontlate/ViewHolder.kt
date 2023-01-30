package com.example.dontlate

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    var view : View = v

    fun bind(item : board) {
        view.board_title.text = item.board_title
        view.board_place.text = item.board_place
        view.board_date.text = item.board_date
        view.board_current.text = item.board_current
        view.board_possible.text = item.board_possible
    }
}