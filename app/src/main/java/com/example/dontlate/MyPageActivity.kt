package com.example.dontlate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.math.log

class MyPageActivity : AppCompatActivity() {

    lateinit var logoutBtn: Button
    lateinit var accountBtn: Button
    lateinit var historyBtn: Button
    lateinit var settingBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        logoutBtn = findViewById(R.id.logoutBtn)
        accountBtn = findViewById(R.id.accountBtn)
        historyBtn = findViewById(R.id.historyBtn)
        settingBtn = findViewById(R.id.settingBtn)

        logoutBtn.setOnClickListener{
            var intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }

        accountBtn.setOnClickListener{
            var intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
        }

        historyBtn.setOnClickListener{
            var intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        settingBtn.setOnClickListener{
            var intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
    }
}