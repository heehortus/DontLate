package com.example.dontlate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import org.w3c.dom.Text

class SummaryActivity : AppCompatActivity() {

    private lateinit var summaryTitle : TextView
    private lateinit var personnelText : TextView
    private lateinit var dateText : TextView
    private lateinit var placeText : TextView
    private lateinit var inviteCode : TextView
    private lateinit var deadlineText : TextView
    private lateinit var mentionText : EditText

    private lateinit var privateImg : ImageView

    private lateinit var newBtn : Button
    private lateinit var clipboardBtn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        // 텍스트 및 버튼 선언
        summaryTitle = findViewById(R.id.summaryTitle)
        personnelText = findViewById(R.id.personnelText)
        dateText = findViewById(R.id.dateText)
        placeText = findViewById(R.id.placeText)
        inviteCode = findViewById(R.id.inviteCode)
        deadlineText = findViewById(R.id.deadlineText)
        mentionText = findViewById(R.id.mentionText)

        privateImg = findViewById(R.id.privateImg)

        newBtn = findViewById(R.id.newBtn)
        clipboardBtn = findViewById(R.id.clipboardBtn)


        // 이전 화면에서 데이터 받아오기
        var intent = intent
        var headID = intent.getStringExtra("headID")
        var name = intent.getStringExtra("name")
        var total_num = intent.getStringExtra("total_num")
        var place = intent.getStringExtra("place")
        var mention = intent.getStringExtra("mention")
        var deadline = intent.getStringExtra("deadline")
        var private = intent.getStringExtra("object")
        var ivtCode = intent.getStringExtra("inviteCode")
        var date = intent.getStringExtra("date")
        var time = intent.getStringExtra("time")

        Toast.makeText(this@SummaryActivity, headID, Toast.LENGTH_SHORT).show()

        summaryTitle.text = name
        personnelText.text = "$total_num 명"
        dateText.text = date
        placeText.text = place
        inviteCode.text = ivtCode
        deadlineText.text = deadline
        mentionText.setText(mention)

        if(private == "public") privateImg.visibility = View.GONE
    }
}