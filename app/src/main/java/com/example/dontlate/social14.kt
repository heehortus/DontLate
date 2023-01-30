package com.example.dontlate

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.social_layout14.*
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
        deadline = "${datePicker.year.toString()}-${(datePicker.month + 1).toString()}-${datePicker.dayOfMonth.toString()}"

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
            var intent = Intent(this@social14, social17::class.java)
            Toast.makeText(this@social14, deadline, Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}