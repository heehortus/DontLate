package com.example.dontlate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    //임시 사용
    lateinit var startBtn: Button

    private lateinit var splashScreen: SplashScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreen = installSplashScreen()
        setContentView(R.layout.activity_main)

        //임시 사용
        startBtn = findViewById(R.id.validation)

        startBtn.setOnClickListener {
            var intent = Intent(this, StartupActivity::class.java)
            startActivity(intent)
        }
    }
}