package com.example.dontlate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MyPageActivity : AppCompatActivity() {

    lateinit var logoutBtn: Button
    lateinit var accountBtn: Button
    lateinit var historyBtn: Button
    lateinit var settingBtn: Button

    //폰트 사이즈 변경
    lateinit var version : TextView
    lateinit var versionInfo : TextView

    var dialog : CustomDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        dialog = CustomDialog(this)

        logoutBtn = findViewById(R.id.logoutBtn)
        accountBtn = findViewById(R.id.accountBtn)
        historyBtn = findViewById(R.id.historyBtn)
        settingBtn = findViewById(R.id.settingBtn)

        version = findViewById(R.id.version)
        versionInfo = findViewById(R.id.versionInfo)

        logoutBtn.setOnClickListener{
            dialog!!.start("로그아웃 하시겠어요?", 1, 2, this@MyPageActivity)
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

        //폰트 사이즈 설정
        val font: Float = (application as textApplication).getSize()
        accountBtn.textSize = font
        historyBtn.textSize = font
        settingBtn.textSize = font
        logoutBtn.textSize = font
        version.textSize = font
        versionInfo.textSize = font
    }
}