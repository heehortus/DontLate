package com.example.dontlate

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dontlate.social17.*
import java.util.*

class social17 : AppCompatActivity() {

    private lateinit var ivtcode: TextView
    private lateinit var nextBtn: Button
    private lateinit var publicBtn: Button
    private lateinit var privateBtn: Button
    private lateinit var lctBtn: Button
    private lateinit var backBtn: ImageButton
    private lateinit var dltBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.social_layout17)

        nextBtn = findViewById(R.id.s17_next_btn)
        backBtn = findViewById(R.id.s17_back_btn)
        dltBtn = findViewById(R.id.s17_dlt_btn)
        lctBtn = findViewById(R.id.s17_lct_btn)
        publicBtn = findViewById(R.id.s17_public_btn)
        privateBtn = findViewById(R.id.s17_private_btn)
        ivtcode = findViewById(R.id.s17_ivtcode)

        backBtn.setOnClickListener(BackClickListener())
        dltBtn.setOnClickListener(DltClickListener())
        nextBtn.setOnClickListener(NextClickListener())
        lctBtn.setOnClickListener(LctClickListener())
        publicBtn.setOnClickListener(PublicClickListener())
        privateBtn.setOnClickListener(PrivateClickListener())


        //초대코드 랜덤생성
        val rnd = Random()
        val code1 = (rnd.nextInt(26) + 97).toChar().toString() //영어 소문자 a-z
        val code2 = (rnd.nextInt(26) + 65).toChar().toString() //영어 대문자 A-Z
        val code3 = (rnd.nextInt(26) + 97).toChar().toString() //영어 소문자 a-z
        val code4 = (rnd.nextInt(26) + 97).toChar().toString() //영어 소문자 a-z
        val code5 = (rnd.nextInt(26) + 65).toChar().toString() //영어 대문자 A-Z
        val code6 = (rnd.nextInt(26) + 97).toChar().toString() //영어 소문자 a-z
        ivtcode.setText(code1 + code2 + code3 + code4 + code5 + code6)

    }

    internal inner class NextClickListener : View.OnClickListener {
        override fun onClick(v: View) {
            // nextBtn Click 이벤트 처리 구간
            val intent = Intent(applicationContext, social25::class.java)
            startActivity(intent)
        }
    }

    internal inner class BackClickListener : View.OnClickListener {
        override fun onClick(v: View) {
            // backBtn Click 이벤트 처리 구간
            val intent = Intent(applicationContext, social14::class.java)
            startActivity(intent)
        }
    }

    internal inner class DltClickListener : View.OnClickListener {
        override fun onClick(v: View) {
            // dltBtn Click 이벤트 처리 구간
            finish()
        }
    }

    internal inner class LctClickListener : View.OnClickListener {
        override fun onClick(v: View) {
            // lctBtn Click 이벤트 처리 구간
            val intent = Intent(applicationContext, social21::class.java)
            startActivity(intent)
        }
    }

    internal inner class PublicClickListener : View.OnClickListener {
        var num = 0
        override fun onClick(v: View) {
            // Private Click 이벤트 처리 구간
            num++
            // 눌리면
            if (num % 2 == 1) {
                publicBtn!!.background = getDrawable(R.drawable.social_whitebutton_orangeborder)
                publicBtn!!.setTextColor(Color.parseColor("#E88B58"))
                privateBtn!!.background = getDrawable(R.drawable.social_whitebutton_grayborder)
                privateBtn!!.setTextColor(Color.parseColor("#474747"))
                // 다시 누르면
            } else {
                publicBtn!!.background = getDrawable(R.drawable.social_whitebutton_grayborder)
                publicBtn!!.setTextColor(Color.parseColor("#474747"))
            }
        }
    }

    internal inner class PrivateClickListener : View.OnClickListener {
        var num = 0
        override fun onClick(v: View) {

            // Private Click 이벤트 처리 구간
            num++
            // 눌리면
            if (num % 2 == 1) {
                privateBtn!!.background = getDrawable(R.drawable.social_whitebutton_orangeborder)
                privateBtn!!.setTextColor(Color.parseColor("#E88B58"))
                publicBtn!!.background = getDrawable(R.drawable.social_whitebutton_grayborder)
                publicBtn!!.setTextColor(Color.parseColor("#474747"))
                // 다시 누르면
            } else {
                privateBtn!!.background = getDrawable(R.drawable.social_whitebutton_grayborder)
                privateBtn!!.setTextColor(Color.parseColor("#474747"))
            }
        }
    }
}