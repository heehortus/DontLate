package com.example.dontlate

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class social14 : AppCompatActivity() {

    private lateinit var nextBtn: Button
    private lateinit var backBtn: ImageButton
    private lateinit var dltBtn: ImageButton
    private lateinit var plus: ImageButton
    private lateinit var min: ImageButton
    private lateinit var numText: TextView
    private var count = 2

    private lateinit var datePicker : DatePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.social_layout14)

        backBtn = findViewById(R.id.s14_back_btn)
        dltBtn = findViewById(R.id.s14_dlt_btn)
        nextBtn = findViewById(R.id.s14_next_btn)
        plus = findViewById(R.id.plus)
        min = findViewById(R.id.min)
        numText = findViewById(R.id.numText)
        datePicker = findViewById(R.id.datePicker)


        //회원 아이디 정보 받아오기
        var intent = intent
        var user_id = intent.getStringExtra("user_id").toString()
        Toast.makeText(this@social14, user_id, Toast.LENGTH_SHORT).show()

        numText.text = "$count 명"

        backBtn.setOnClickListener {
            finish()
        }

        dltBtn.setOnClickListener {
            finish()
        }

        plus.setOnClickListener {
            // Plus Click 이벤트 처리 구간
            if (count in 2..5) {
                count++
                numText.text = "$count 명"
            } else {
                numText.text = "$count 명"
            }
        }

        min.setOnClickListener {
            if (count in 3..6) {
                count--
                numText.text = "$count 명"
            } else {
                numText.text = "$count 명"
            }
        }

        nextBtn.setOnClickListener {
            //요일 받아오기
            var date = "${datePicker.year}/${(datePicker.month + 1)}/${datePicker.dayOfMonth}"
            var dayOfTheWeek = getDateDay(date, "yy/MM/dd") + "요일"

            var deadline = "${(datePicker.month + 1)}월 ${datePicker.dayOfMonth}일 $dayOfTheWeek"

            var intent = Intent(this, social17::class.java)
            Toast.makeText(this@social14, "$count/$deadline", Toast.LENGTH_SHORT).show()
            intent.putExtra("total_num", "$count")
            intent.putExtra("deadline", deadline)
            intent.putExtra("headID", user_id)
            startActivity(intent)
        }
    }

    /**
     * 특정 날짜에 대하여 요일을 구함(일 ~ 토)
     * @param date
     * @param dateType
     * @return
     * @throws Exception
     */
    @RequiresApi(Build.VERSION_CODES.N)
    @Throws(Exception::class)
    fun getDateDay(date: String?, dateType: String?): String? {
        var day = ""
        val dateFormat = SimpleDateFormat(dateType)
        val nDate: Date = dateFormat.parse(date)
        val cal = Calendar.getInstance()
        cal.time = nDate
        val dayNum = cal[Calendar.DAY_OF_WEEK]
        when (dayNum) {
            1 -> day = "일"
            2 -> day = "월"
            3 -> day = "화"
            4 -> day = "수"
            5 -> day = "목"
            6 -> day = "금"
            7 -> day = "토"
        }
        return day
    }
}