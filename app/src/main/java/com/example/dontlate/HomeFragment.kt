package com.example.dontlate

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentTransaction
import com.example.dontlate.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding

    //데이터베이스 선언
    lateinit var personnelDBManager: personnelDBManager
    lateinit var sqlitedb: SQLiteDatabase

    // 회원 정보
    lateinit var user_id : String
    lateinit var user_name : String
    lateinit var user_image : String

    // 폰트 사이즈
    var font : Float = 16F


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("Range")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
         MainActivity에서 넘어온 데이터를 String으로 변환
          —> 로그인한 회원 정보 업데이트
         */
        var bundle = arguments
        user_id = bundle?.getString("user_id").toString()
        user_name = bundle?.getString("user_name").toString()
        user_image = bundle?.getString("user_image").toString()
        font = bundle?.getFloat("fontSize")!!.toFloat()

        // 데이터베이스 연결
        personnelDBManager = personnelDBManager(requireActivity(), user_id, null, 1)
        var cursor : Cursor

        sqlitedb = personnelDBManager.readableDatabase
        cursor = sqlitedb.rawQuery("SELECT * FROM $user_id;", null)

        val listBoard = ArrayList<home_board>()

        while (cursor.moveToNext()) {
            var user_id = cursor.getString(cursor.getColumnIndex("user_id")).toString()
            var headID = cursor.getString(cursor.getColumnIndex("headID")).toString()
            var title = cursor.getString(cursor.getColumnIndex("title")).toString()
            var date = cursor.getString(cursor.getColumnIndex("date")).toString()
            var place = cursor.getString(cursor.getColumnIndex("place")).toString()
            var state = cursor.getString(cursor.getColumnIndex("state")).toString()

            listBoard.add(
                home_board("$user_id","$headID","$title", "$place", "$date",
                    "$state")
            )
        }

        if(cursor != null)
        {
            binding.homeImage.isInvisible = true
            binding.homeEmptyText.isInvisible = true
        }

        val adapter = HomeListAdapter(listBoard)
        binding.recyclerHome.adapter = adapter

    }
}