package com.example.dontlate

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton

class joinActivity : AppCompatActivity() {

    lateinit var startBtn: Button
    lateinit var backBtn: Button
    lateinit var loginBtn: Button

    //중복 확인 버튼
    lateinit var checkBtn: AppCompatButton
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        startBtn = findViewById(R.id.startBtn)
        backBtn = findViewById(R.id.backBtnA)
        loginBtn = findViewById(R.id.loginBtn)

        //중복 확인
        checkBtn = findViewById(R.id.checkBtn)

        //중복 확인 버튼 리스너
        checkBtn.setOnClickListener{
            //데이터베이스 속 아이디와 겹치는 것이 없을 경우 -> 버튼 색상 변경
            checkBtn.setBackgroundDrawable(getDrawable(R.drawable.btn_clicked))
            checkBtn.text = "확인 완료"
            checkBtn.setTextColor(Color.parseColor("#5F893E"))
        }

        //시작 버튼 리스너 설정
        startBtn.setOnClickListener{
            var intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }

        //돌아 가기 버튼 클릭 리스너 설정
        backBtn.setOnClickListener{
            var intent = Intent(this, StartupActivity::class.java)
            startActivity(intent)
        }

        //로그인 버튼 클릭 리스너 설정
        loginBtn.setOnClickListener{
            var intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }
    }
}