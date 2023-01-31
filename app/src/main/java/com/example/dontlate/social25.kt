package com.example.dontlate

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class social25 : AppCompatActivity() {

    //객체 생성
    private lateinit var nextBtn: Button
    private lateinit var backBtn: ImageButton
    private lateinit var dltBtn: ImageButton
    private lateinit var datePicker: DatePicker

    private lateinit var date : String
    private lateinit var day : String
    private lateinit var month : String


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.social_layout25)

        nextBtn = findViewById(R.id.s25_next_btn)
        backBtn = findViewById(R.id.s25_back_btn)
        dltBtn = findViewById(R.id.s25_dlt_btn)
        datePicker = findViewById(R.id.datePicker)


        // 이전 화면에서 데이터 넘겨받기
        var intent = intent
        var headID = intent.getStringExtra("headID")
        var name = intent.getStringExtra("name")
        var total_num = intent.getStringExtra("total_num")
        var place = intent.getStringExtra("place")
        var mention = intent.getStringExtra("mention")
        var deadline = intent.getStringExtra("deadline")
        var private = intent.getStringExtra("object")
        var inviteCode = intent.getStringExtra("inviteCode")

        backBtn.setOnClickListener {
            val intent = Intent(this, social17::class.java)
            intent.putExtra("headID", headID)
            intent.putExtra("name", name)
            intent.putExtra("total_num", total_num)
            intent.putExtra("place", place)
            intent.putExtra("mention", mention)
            intent.putExtra("deadline", deadline)
            intent.putExtra("object", private)
            intent.putExtra("inviteCode", inviteCode)
            startActivity(intent)
        }

        dltBtn.setOnClickListener {
            finish()
        }

        nextBtn.setOnClickListener {

            month = (datePicker.month + 1).toString() + "월"
            date = (datePicker.dayOfMonth + 1).toString() + "일"

            //요일 받아오기
            date = "${datePicker.year}/${(datePicker.month + 1)}/${datePicker.dayOfMonth}"
            var dayOfTheWeek = getDateDay(date, "yy/MM/dd") + "요일"
            var day = "${(datePicker.month + 1)}월 ${datePicker.dayOfMonth}일 $dayOfTheWeek"

            //화면 넘기기
            val intent = Intent(this, social27::class.java)
            intent.putExtra("headID", headID)
            intent.putExtra("name", name)
            intent.putExtra("total_num", total_num)
            intent.putExtra("place", place)
            intent.putExtra("mention", mention)
            intent.putExtra("deadline", deadline)
            intent.putExtra("object", private)
            intent.putExtra("inviteCode", inviteCode)
            intent.putExtra("date", day)
            intent.putExtra("dayOfTheWeek", dayOfTheWeek)
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