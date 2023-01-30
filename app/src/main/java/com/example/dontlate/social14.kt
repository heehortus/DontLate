package com.example.dontlate

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.social_layout14.*
import java.text.SimpleDateFormat
import java.util.*

class social14 : AppCompatActivity() {

    private lateinit var nextBtn: Button
    private lateinit var backBtn: ImageButton
    private lateinit var dltBtn: ImageButton

    private lateinit var plus: ImageButton
    private lateinit var min: ImageButton
    private lateinit var numText: TextView
    private var person_num = 2

    private lateinit var datePicker: DatePicker
    private lateinit var deadline : String
    var mYear : Int = 0
    var mMonth : Int = 0
    var mDay : Int = 0

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

        numText.text = "${person_num.toString()} 명"

        plus.setOnClickListener {
            person_num++
            numText.text = "${person_num.toString()} 명"
        }

        min.setOnClickListener {
            person_num--
            numText.text = "${person_num.toString()} 명"
        }

        backBtn.setOnClickListener {
            finish()
        }

        dltBtn.setOnClickListener {
            finish()
        }

        nextBtn.setOnClickListener {
            var date = "${datePicker.year}/${(datePicker.month + 1)}/${datePicker.dayOfMonth}"
            var dayOfTheWeek = getDateDay(date, "yy/MM/dd")

            deadline = "${(datePicker.month + 1)}월 ${datePicker.dayOfMonth}일 ${dayOfTheWeek}요일"
            var intent = Intent(this@social14, social17::class.java)
            intent.putExtra("person_num", "$person_num")
            intent.putExtra("deadline", deadline)
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