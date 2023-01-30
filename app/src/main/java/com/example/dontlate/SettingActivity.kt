package com.example.dontlate

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SettingActivity : AppCompatActivity() {

    // 기본 버튼 선언
    lateinit var backBtn: Button
    lateinit var fontSizeBtn: Button

    // 로그인 정보 받아오기 : 데이터베이스
    lateinit var userDbManager : userDBManager
    lateinit var sqlitedb: SQLiteDatabase
    lateinit var str_name : String
    lateinit var imageUri: String

    // 폰트 사이즈 변경을 위한 텍스트 선언
    lateinit var notificationText : TextView


    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        backBtn = findViewById(R.id.backBtnS)
        fontSizeBtn = findViewById(R.id.fontSizeBtn)
        notificationText = findViewById(R.id.notificationText)

        // 폰트 사이즈 값 받아오기
        val font: Float = (application as textApplication).getSize()


        // 로그인한 회원 정보 받아오기
        val intent = intent
        val user_id = intent.getStringExtra("user_id").toString()

        // 데이터베이스 연결
        userDbManager = userDBManager(this@SettingActivity, "user_info", null, 1)
        var cursor : Cursor

        sqlitedb = userDbManager.readableDatabase
        cursor = sqlitedb.rawQuery("SELECT * FROM user_info WHERE ID = '$user_id';", null)

        while (cursor.moveToNext()) {
            str_name = cursor.getString(cursor.getColumnIndex("name")).toString()
            imageUri = cursor.getString(cursor.getColumnIndex("profile")).toString()
        }
        sqlitedb.close()
        cursor.close()

        backBtn.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("selectedItem", "mypage")
            intent.putExtra("user_id", user_id)
            intent.putExtra("user_image", imageUri)
            intent.putExtra("user_name", str_name)
            intent.putExtra("fontSize", font)
            startActivity(intent)
        }

        fontSizeBtn.setOnClickListener{
            var intent = Intent(this, FontSizeActivity::class.java)
            intent.putExtra("user_id", user_id)
            startActivity(intent)
        }

        // 폰트 사이즈 적용
        notificationText.textSize = font
        fontSizeBtn.textSize = font
    }
}