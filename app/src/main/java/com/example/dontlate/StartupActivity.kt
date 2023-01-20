package com.example.dontlate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartupActivity : AppCompatActivity() {

    lateinit var loginBtn: Button
    lateinit var joinBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup)

        loginBtn = findViewById(R.id.loginBtn)
        joinBtn = findViewById(R.id.joinBtn)

        loginBtn.setOnClickListener{
            var intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }

        joinBtn.setOnClickListener{
            var intent = Intent(this, joinActivity::class.java)
            startActivity(intent)
        }
    }
}