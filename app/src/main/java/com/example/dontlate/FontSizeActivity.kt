package com.example.dontlate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FontSizeActivity : AppCompatActivity() {

    lateinit var backBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_font_size)

        backBtn = findViewById(R.id.backBtnF)

        backBtn.setOnClickListener{
            var intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
    }
}