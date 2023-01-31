package com.example.dontlate

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dontlate.RecyclerTouchListener.ClickListener
import com.example.dontlate.databinding.FragmentSocialBinding


class SocialFragment : Fragment() {

    lateinit var binding : FragmentSocialBinding

    // 데이터베이스 선언
    lateinit var serverDBManager: serverDBManager
    lateinit var sqlitedb: SQLiteDatabase

    // 회원 정보
    lateinit var user_id : String
    lateinit var user_name : String
    lateinit var user_image : String

    // 폰트 사이즈
    var font : Float = 16F


    lateinit var title : String
    lateinit var headID : String
    lateinit var date : String
    lateinit var place : String
    lateinit var total_num : String
    lateinit var current_num : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSocialBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("Range")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtonOnClick()

        /*
         MainActivity에서 넘어온 데이터를 String으로 변환
          --> 로그인한 회원 정보 업데이트
         */
        var bundle = arguments
        user_id = bundle?.getString("user_id").toString()
        user_name = bundle?.getString("user_name").toString()
        user_image = bundle?.getString("user_image").toString()
        font = bundle?.getFloat("fontSize")!!.toFloat()

        // 데이터베이스 연결
        serverDBManager = serverDBManager(requireActivity(), "server", null, 1)
        var cursor : Cursor

        sqlitedb = serverDBManager.readableDatabase
        cursor = sqlitedb.rawQuery("SELECT * FROM server;", null)

        val listBoard = ArrayList<board>()

        while (cursor.moveToNext()) {
            headID = cursor.getString(cursor.getColumnIndex("headID")).toString()
            title = cursor.getString(cursor.getColumnIndex("title")).toString()
            date = cursor.getString(cursor.getColumnIndex("date")).toString()
            place = cursor.getString(cursor.getColumnIndex("place")).toString()
            total_num = cursor.getString(cursor.getColumnIndex("total_num")).toString()
            current_num = cursor.getString(cursor.getColumnIndex("current_num")).toString()

            listBoard.add(
                board("$title", "$place", "$date",
                    "$current_num", "$total_num")
            )
        }

        val adapter = BoardListAdapter(listBoard)
        binding.recyclerBoard.adapter = adapter

        binding.recyclerBoard.addOnItemTouchListener(
            RecyclerTouchListener(
                activity,
                binding.recyclerBoard,
                object : ClickListener {
                    override fun onClick(view: View?, position: Int) {
                        var intent = Intent(getActivity(), social35::class.java)
                        intent.putExtra("user_id", user_id)
                        intent.putExtra("headID", headID)
                        intent.putExtra("title", title)
                        intent.putExtra("date", date)
                        startActivity(intent)
                    }

                    override fun onLongClick(view: View?, position: Int) {}
                })
        )

    }

    private fun initButtonOnClick() {
        binding.root.run {
            binding.s13Fab.setOnClickListener {
                // FAB Click 이벤트 처리 구간
                val intent = Intent(getActivity(), social14::class.java)
                intent.putExtra("user_id", user_id)
                startActivity(intent)
            }

            binding.s13NotiBtn.setOnClickListener {
                val intent = Intent(getActivity(), social41::class.java)
                intent.putExtra("user_id", user_id)
                startActivity(intent)
            }

            binding.keyword1.setOnClickListener {
                binding.keyword1.setClickable(true)
                binding.keyword2.setClickable(false)
                binding.keyword3.setClickable(false)
                binding.keyword4.setClickable(false)
                binding.keyword5.setClickable(false)

            }

            binding.keyword2.setOnClickListener {  }

            binding.keyword3.setOnClickListener {  }

            binding.keyword4.setOnClickListener {  }

            binding.keyword5.setOnClickListener {  }

        }
    }

}