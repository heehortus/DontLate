package com.example.dontlate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class joinActivity : AppCompatActivity() {

    lateinit var startBtn: Button
    lateinit var backBtn: Button
    lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        startBtn = findViewById(R.id.startBtn)
        backBtn = findViewById(R.id.backBtnA)
        loginBtn = findViewById(R.id.loginBtn)

        startBtn.setOnClickListener{
            var intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }

        backBtn.setOnClickListener{
            var intent = Intent(this, StartupActivity::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener{
            var intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }
    }
}