package com.example.dontlate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SettingActivity : AppCompatActivity() {
    //폰트 사이즈 설정
    lateinit var notificationText: TextView

    lateinit var backBtn: Button
    lateinit var fontSizeBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        backBtn = findViewById(R.id.backBtnS)
        fontSizeBtn = findViewById(R.id.fontSizeBtn)
        notificationText = findViewById(R.id.notificationText)

        backBtn.setOnClickListener{
            var intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }

        fontSizeBtn.setOnClickListener{
            var intent = Intent(this, FontSizeActivity::class.java)
            startActivity(intent)
        }


        //폰트 사이즈 설정
        val font: Float = (application as textApplication).getSize()
        notificationText.textSize = font
        fontSizeBtn.textSize = font
    }
}