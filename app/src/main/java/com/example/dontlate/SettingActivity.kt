package com.example.dontlate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SettingActivity : AppCompatActivity() {

    lateinit var backBtn: Button
    lateinit var fontSizeBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        backBtn = findViewById(R.id.backBtnS)
        fontSizeBtn = findViewById(R.id.fontSizeBtn)

        backBtn.setOnClickListener{
            var intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }

        fontSizeBtn.setOnClickListener{
            var intent = Intent(this, FontSizeActivity::class.java)
            startActivity(intent)
        }
    }
}