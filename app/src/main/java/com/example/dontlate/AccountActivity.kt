package com.example.dontlate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AccountActivity : AppCompatActivity() {

    lateinit var backBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        backBtn = findViewById(R.id.backBtnA)

        backBtn.setOnClickListener{
            var intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }
    }
}