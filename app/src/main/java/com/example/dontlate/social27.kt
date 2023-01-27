package com.example.dontlate

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class social27 : AppCompatActivity() {

    private lateinit var nextBtn: Button
    private lateinit var backBtn: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.social_layout27)


        nextBtn = findViewById(R.id.s27_next_btn)
        backBtn = findViewById(R.id.s27_back_btn)

        backBtn.setOnClickListener(BackClickListener())
        nextBtn.setOnClickListener(NextClickListener())
    }


    internal inner class NextClickListener : View.OnClickListener {
        override fun onClick(v: View) {
            // nextBtn Click 이벤트 처리 구간
            // 초기화면으로 돌아가기
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

    internal inner class BackClickListener : View.OnClickListener {
        override fun onClick(v: View) {
            // backBtn Click 이벤트 처리 구간
            val intent = Intent(applicationContext, social25::class.java)
            startActivity(intent)
        }
    }
}