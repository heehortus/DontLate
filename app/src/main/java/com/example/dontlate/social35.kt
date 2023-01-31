package com.example.dontlate

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text
import java.net.IDN

class social35 : AppCompatActivity() {

    private lateinit var nextBtn: Button
    private lateinit var backBtn: ImageButton

    // 약속 정보 저장 : 데이터베이스
    lateinit var personnelDBManager: personnelDBManager
    lateinit var serverDBManager: serverDBManager
    lateinit var sqlitedb: SQLiteDatabase

    // 로그인 정보 받아오기 : 데이터베이스
    lateinit var userDbManager : userDBManager
    lateinit var str_name : String
    lateinit var str_id : String
    lateinit var str_password : String
    lateinit var imageUri : String
    lateinit var userImage : ImageView

    lateinit var headID : String
    lateinit var title : String
    lateinit var place : String
    lateinit var date : String
    lateinit var total_num : String
    lateinit var current_num : String
    lateinit var deadline : String
    lateinit var private : String
    lateinit var mention : String

    lateinit var titleText : TextView
    lateinit var nickname : TextView
    lateinit var privateText : TextView
    lateinit var mentionText : TextView
    lateinit var current : TextView
    lateinit var placeText : TextView
    lateinit var deadlineText : TextView
    lateinit var placeBtn : Button


    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.social_layout35)

        nextBtn = findViewById(R.id.s35_next_btn)
        backBtn = findViewById(R.id.s35_back_btn)
        userImage = findViewById(R.id.img_user4)

        titleText = findViewById(R.id.title35)
        nickname = findViewById(R.id.name35)
        privateText = findViewById(R.id.private35)
        mentionText = findViewById(R.id.mention35)
        current = findViewById(R.id.current35)
        placeText = findViewById(R.id.place35)
        deadlineText = findViewById(R.id.deadline35)
        placeBtn = findViewById(R.id.s35_lct_btn)


        var intent = intent
        headID = intent.getStringExtra("headID").toString()
        title = intent.getStringExtra("title").toString()
        date = intent.getStringExtra("date").toString()

        userDbManager = userDBManager(this@social35, "user_info", null, 1)
        var cursor : Cursor
        sqlitedb = userDbManager.readableDatabase
        cursor = sqlitedb.rawQuery("SELECT * FROM user_info WHERE ID = '$headID';", null)
        while (cursor.moveToNext()) {
            //회원 정보 반영
            str_id = cursor.getString(cursor.getColumnIndex("ID")).toString()
            str_password = cursor.getString(cursor.getColumnIndex("password")).toString()
            str_name = cursor.getString(cursor.getColumnIndex("name")).toString()
            imageUri = cursor.getString(cursor.getColumnIndex("profile")).toString()
        }
        cursor.close()

        serverDBManager = serverDBManager(this@social35, "server", null, 1)
        sqlitedb = serverDBManager.readableDatabase
        cursor = sqlitedb.rawQuery("SELECT * FROM server WHERE headID = '$headID' AND title = '$title' AND date = '$date'", null)

        while (cursor.moveToNext()) {
            place = cursor.getString(cursor.getColumnIndex("place")).toString()
            total_num = cursor.getString(cursor.getColumnIndex("total_num")).toString()
            current_num = cursor.getString(cursor.getColumnIndex("current_num")).toString()
            deadline = cursor.getString(cursor.getColumnIndex("deadline")).toString()
            private = cursor.getString(cursor.getColumnIndex("object")).toString()
            mention = cursor.getString(cursor.getColumnIndex("mention")).toString()
        }

        titleText.text = title
        nickname.text = str_name
        privateText.text = private
        mentionText.text = mention
        current.text = "$current_num/$total_num"
        placeText.text = place
        deadlineText.text = deadline
        placeBtn.text = place

        Glide.with(this)
            .load(imageUri)
            .apply(RequestOptions.centerCropTransform().circleCrop())
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(userImage)

        serverDBManager.close()
        sqlitedb.close()
        cursor.close()

        backBtn.setOnClickListener(BackClickListener())
        nextBtn.setOnClickListener(NextClickListener())
    }


    internal inner class NextClickListener : View.OnClickListener {
        override fun onClick(v: View) {
            // nextBtn Click 이벤트 처리 구간
            val intent = Intent(applicationContext, social37::class.java)
            intent.putExtra("user_id", str_id)
            intent.putExtra("headID", headID)
            intent.putExtra("title", title)
            intent.putExtra("date", date)
            startActivity(intent)
        }
    }

    internal inner class BackClickListener : View.OnClickListener {
        override fun onClick(v: View) {
            // backBtn Click 이벤트 처리 구간
            finish()
        }
    }
}