package com.example.dontlate

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.board_state
import kotlinx.android.synthetic.main.item.view.board_date
import kotlinx.android.synthetic.main.item.view.board_place
import kotlinx.android.synthetic.main.item.view.board_title

class ViewHolder_home (v: View) : RecyclerView.ViewHolder(v) {
    var view : View = v

    fun bind(item : home_board) {
        view.board_title.text = item.board_title
        view.board_place.text = item.board_place
        view.board_date.text = item.board_date
        view.board_state.text = item.state
    }
}