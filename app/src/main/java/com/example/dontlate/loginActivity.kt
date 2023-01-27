package com.example.dontlate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class loginActivity : AppCompatActivity() {

    lateinit var backBtn: Button

    //화면 확인 위한 임의 설정
    lateinit var startBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        backBtn = findViewById(R.id.backBtnA)

        //화면 확인 위한 임의 설정
        startBtn = findViewById(R.id.startBtn)

        //뒤로 가기 버튼
        backBtn.setOnClickListener{
            var intent = Intent(this, StartupActivity::class.java)
            startActivity(intent)
        }

        //화면 확인 위한 임의 설정
        startBtn.isEnabled = true

        //시작하기 버튼
        startBtn.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}