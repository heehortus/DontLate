package com.example.dontlate

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class social33 : AppCompatActivity(), View.OnClickListener {

    var time: String = "TIME"

    private lateinit var nextBtn: Button
    private lateinit var backBtn: ImageButton
    private lateinit var dltBtn: ImageButton
    private lateinit var selectedTime : String
    private lateinit var selectedTimeText : TextView

    private lateinit var mon10: Button
    private lateinit var tue10: Button
    private lateinit var wed10: Button
    private lateinit var thu10: Button
    private lateinit var fri10: Button
    private lateinit var sat10: Button
    private lateinit var sun10: Button
    private lateinit var mon11: Button
    private lateinit var tue11: Button
    private lateinit var wed11: Button
    private lateinit var thu11: Button
    private lateinit var fri11: Button
    private lateinit var sat11: Button
    private lateinit var sun11: Button
    private lateinit var mon12: Button
    private lateinit var tue12: Button
    private lateinit var wed12: Button
    private lateinit var thu12: Button
    private lateinit var fri12: Button
    private lateinit var sat12: Button
    private lateinit var sun12: Button
    private lateinit var mon13: Button
    private lateinit var tue13: Button
    private lateinit var wed13: Button
    private lateinit var thu13: Button
    private lateinit var fri13: Button
    private lateinit var sat13: Button
    private lateinit var sun13: Button
    private lateinit var mon14: Button
    private lateinit var tue14: Button
    private lateinit var wed14: Button
    private lateinit var thu14: Button
    private lateinit var fri14: Button
    private lateinit var sat14: Button
    private lateinit var sun14: Button
    private lateinit var mon15: Button
    private lateinit var tue15: Button
    private lateinit var wed15: Button
    private lateinit var thu15: Button
    private lateinit var fri15: Button
    private lateinit var sat15: Button
    private lateinit var sun15: Button
    private lateinit var mon16: Button
    private lateinit var tue16: Button
    private lateinit var wed16: Button
    private lateinit var thu16: Button
    private lateinit var fri16: Button
    private lateinit var sat16: Button
    private lateinit var sun16: Button
    private lateinit var mon17: Button
    private lateinit var tue17: Button
    private lateinit var wed17: Button
    private lateinit var thu17: Button
    private lateinit var fri17: Button
    private lateinit var sat17: Button
    private lateinit var sun17: Button
    private lateinit var mon18: Button
    private lateinit var tue18: Button
    private lateinit var wed18: Button
    private lateinit var thu18: Button
    private lateinit var fri18: Button
    private lateinit var sat18: Button
    private lateinit var sun18: Button
    private lateinit var mon19: Button
    private lateinit var tue19: Button
    private lateinit var wed19: Button
    private lateinit var thu19: Button
    private lateinit var fri19: Button
    private lateinit var sat19: Button
    private lateinit var sun19: Button
    private lateinit var mon20: Button
    private lateinit var tue20: Button
    private lateinit var wed20: Button
    private lateinit var thu20: Button
    private lateinit var fri20: Button
    private lateinit var sat20: Button
    private lateinit var sun20: Button
    private lateinit var mon21: Button
    private lateinit var tue21: Button
    private lateinit var wed21: Button
    private lateinit var thu21: Button
    private lateinit var fri21: Button
    private lateinit var sat21: Button
    private lateinit var sun21: Button
    private lateinit var mon22: Button
    private lateinit var tue22: Button
    private lateinit var wed22: Button
    private lateinit var thu22: Button
    private lateinit var fri22: Button
    private lateinit var sat22: Button
    private lateinit var sun22: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.social_layout33)

        nextBtn = findViewById(R.id.s33_next_btn)
        backBtn = findViewById(R.id.s33_back_btn)

        mon10 = findViewById(R.id.mon10)
        tue10 = findViewById(R.id.tue10)
        wed10 = findViewById(R.id.wed10)
        thu10 = findViewById(R.id.thu10)
        fri10 = findViewById(R.id.fri10)
        sat10 = findViewById(R.id.sat10)
        sun10 = findViewById(R.id.sun10)
        mon11 = findViewById(R.id.mon11)
        tue11 = findViewById(R.id.tue11)
        wed11 = findViewById(R.id.wed11)
        thu11 = findViewById(R.id.thu11)
        fri11 = findViewById(R.id.fri11)
        sat11 = findViewById(R.id.sat11)
        sun11 = findViewById(R.id.sun11)
        mon12 = findViewById(R.id.mon12)
        tue12 = findViewById(R.id.tue12)
        wed12 = findViewById(R.id.wed12)
        thu12 = findViewById(R.id.thu12)
        fri12 = findViewById(R.id.fri12)
        sat12 = findViewById(R.id.sat12)
        sun12 = findViewById(R.id.sun12)
        mon13 = findViewById(R.id.mon13)
        tue13 = findViewById(R.id.tue13)
        wed13 = findViewById(R.id.wed13)
        thu13 = findViewById(R.id.thu13)
        fri13 = findViewById(R.id.fri13)
        sat13 = findViewById(R.id.sat13)
        sun13 = findViewById(R.id.sun13)
        mon14 = findViewById(R.id.mon14)
        tue14 = findViewById(R.id.tue14)
        wed14 = findViewById(R.id.wed14)
        thu14 = findViewById(R.id.thu14)
        fri14 = findViewById(R.id.fri14)
        sat14 = findViewById(R.id.sat14)
        sun14 = findViewById(R.id.sun14)
        mon15 = findViewById(R.id.mon15)
        tue15 = findViewById(R.id.tue15)
        wed15 = findViewById(R.id.wed15)
        thu15 = findViewById(R.id.thu15)
        fri15 = findViewById(R.id.fri15)
        sat15 = findViewById(R.id.sat15)
        sun15 = findViewById(R.id.sun15)
        mon16 = findViewById(R.id.mon16)
        tue16 = findViewById(R.id.tue16)
        wed16 = findViewById(R.id.wed16)
        thu16 = findViewById(R.id.thu16)
        fri16 = findViewById(R.id.fri16)
        sat16 = findViewById(R.id.sat16)
        sun16 = findViewById(R.id.sun16)
        mon17 = findViewById(R.id.mon17)
        tue17 = findViewById(R.id.tue17)
        wed17 = findViewById(R.id.wed17)
        thu17 = findViewById(R.id.thu17)
        fri17 = findViewById(R.id.fri17)
        sat17 = findViewById(R.id.sat17)
        sun17 = findViewById(R.id.sun17)
        mon18 = findViewById(R.id.mon18)
        tue18 = findViewById(R.id.tue18)
        wed18 = findViewById(R.id.wed18)
        thu18 = findViewById(R.id.thu18)
        fri18 = findViewById(R.id.fri18)
        sat18 = findViewById(R.id.sat18)
        sun18 = findViewById(R.id.sun18)
        mon19 = findViewById(R.id.mon19)
        tue19 = findViewById(R.id.tue19)
        wed19 = findViewById(R.id.wed19)
        thu19 = findViewById(R.id.thu19)
        fri19 = findViewById(R.id.fri19)
        sat19 = findViewById(R.id.sat19)
        sun19 = findViewById(R.id.sun19)
        mon20 = findViewById(R.id.mon20)
        tue20 = findViewById(R.id.tue20)
        wed20 = findViewById(R.id.wed20)
        thu20 = findViewById(R.id.thu20)
        fri20 = findViewById(R.id.fri20)
        sat20 = findViewById(R.id.sat20)
        sun20 = findViewById(R.id.sun20)
        mon21 = findViewById(R.id.mon21)
        tue21 = findViewById(R.id.tue21)
        wed21 = findViewById(R.id.wed21)
        thu21 = findViewById(R.id.thu21)
        fri21 = findViewById(R.id.fri21)
        sat21 = findViewById(R.id.sat21)
        sun21 = findViewById(R.id.sun21)
        mon22 = findViewById(R.id.mon22)
        tue22 = findViewById(R.id.tue22)
        wed22 = findViewById(R.id.wed22)
        thu22 = findViewById(R.id.thu22)
        fri22 = findViewById(R.id.fri22)
        sat22 = findViewById(R.id.sat22)
        sun22 = findViewById(R.id.sun22)


        // 시간표 클릭리스너
        mon10.setOnClickListener(this)
        tue10.setOnClickListener(this)
        wed10.setOnClickListener(this)
        thu10.setOnClickListener(this)
        fri10.setOnClickListener(this)
        sat10.setOnClickListener(this)
        sun10.setOnClickListener(this)
        mon11.setOnClickListener(this)
        tue11.setOnClickListener(this)
        wed11.setOnClickListener(this)
        thu11.setOnClickListener(this)
        fri11.setOnClickListener(this)
        sat11.setOnClickListener(this)
        sun11.setOnClickListener(this)
        mon12.setOnClickListener(this)
        tue12.setOnClickListener(this)
        wed12.setOnClickListener(this)
        thu12.setOnClickListener(this)
        fri12.setOnClickListener(this)
        sat12.setOnClickListener(this)
        sun12.setOnClickListener(this)
        mon13.setOnClickListener(this)
        tue13.setOnClickListener(this)
        wed13.setOnClickListener(this)
        thu13.setOnClickListener(this)
        fri13.setOnClickListener(this)
        sat13.setOnClickListener(this)
        sun13.setOnClickListener(this)
        mon14.setOnClickListener(this)
        tue14.setOnClickListener(this)
        wed14.setOnClickListener(this)
        thu14.setOnClickListener(this)
        fri14.setOnClickListener(this)
        sat14.setOnClickListener(this)
        sun14.setOnClickListener(this)
        mon15.setOnClickListener(this)
        tue15.setOnClickListener(this)
        wed15.setOnClickListener(this)
        thu15.setOnClickListener(this)
        fri15.setOnClickListener(this)
        sat15.setOnClickListener(this)
        sun15.setOnClickListener(this)
        mon16.setOnClickListener(this)
        tue16.setOnClickListener(this)
        wed16.setOnClickListener(this)
        thu16.setOnClickListener(this)
        fri16.setOnClickListener(this)
        sat16.setOnClickListener(this)
        sun16.setOnClickListener(this)
        mon17.setOnClickListener(this)
        tue17.setOnClickListener(this)
        wed17.setOnClickListener(this)
        thu17.setOnClickListener(this)
        fri17.setOnClickListener(this)
        sat17.setOnClickListener(this)
        sun17.setOnClickListener(this)
        mon18.setOnClickListener(this)
        tue18.setOnClickListener(this)
        wed18.setOnClickListener(this)
        thu18.setOnClickListener(this)
        fri18.setOnClickListener(this)
        sat18.setOnClickListener(this)
        sun18.setOnClickListener(this)
        mon19.setOnClickListener(this)
        tue19.setOnClickListener(this)
        wed19.setOnClickListener(this)
        thu19.setOnClickListener(this)
        fri19.setOnClickListener(this)
        sat19.setOnClickListener(this)
        sun19.setOnClickListener(this)
        mon20.setOnClickListener(this)
        tue20.setOnClickListener(this)
        wed20.setOnClickListener(this)
        thu20.setOnClickListener(this)
        fri20.setOnClickListener(this)
        sat20.setOnClickListener(this)
        sun20.setOnClickListener(this)
        mon21.setOnClickListener(this)
        tue21.setOnClickListener(this)
        wed21.setOnClickListener(this)
        thu21.setOnClickListener(this)
        fri21.setOnClickListener(this)
        sat21.setOnClickListener(this)
        sun21.setOnClickListener(this)
        mon22.setOnClickListener(this)
        tue22.setOnClickListener(this)
        wed22.setOnClickListener(this)
        thu22.setOnClickListener(this)
        fri22.setOnClickListener(this)
        sat22.setOnClickListener(this)
        sun22.setOnClickListener(this)


        backBtn.setOnClickListener {
            var intent = Intent(this, social35::class.java)
            startActivity(intent)
        }

//        dltBtn.setOnClickListener {
//            // 초기화면으로 돌아가기
//            val intent = Intent(applicationContext, MainActivity::class.java)
//            startActivity(intent)
//        }

        nextBtn.setOnClickListener {
            // 초기화면으로 돌아가기
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

    }

    // 시간표 다중 클릭 리스너
    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.mon10 -> {
                    this.time = this.time + ",mon10"
                    if (!mon10.isSelected) {
                        mon10.setSelected(true)
                    } else mon10.setSelected(false)
                }
                R.id.mon11 -> {
                    this.time = this.time + ",mon11"
                    if (!mon11.isSelected) {
                        mon11.setSelected(true)
                    } else mon11.setSelected(false)
                }
                R.id.mon12 -> {
                    this.time = this.time + ",mon12"
                    if (!mon12.isSelected) {
                        mon12.setSelected(true)
                    } else mon12.setSelected(false)
                }
                R.id.mon13 -> {
                    this.time = this.time + ",mon13"
                    if (!mon13.isSelected) {
                        mon13.setSelected(true)
                    } else mon13.setSelected(false)
                }
                R.id.mon14 -> {
                    this.time = this.time + ",mon14"
                    if (!mon14.isSelected) {
                        mon14.setSelected(true)
                    } else mon14.setSelected(false)
                }
                R.id.mon15 -> {
                    this.time = this.time + ",mon15"
                    if (!mon15.isSelected) {
                        mon15.setSelected(true)
                    } else mon15.setSelected(false)
                }
                R.id.mon16 -> {
                    this.time = this.time + ",mon16"
                    if (!mon16.isSelected) {
                        mon16.setSelected(true)
                    } else mon16.setSelected(false)
                }
                R.id.mon17 -> {
                    this.time = this.time + ",mon17"
                    if (!mon17.isSelected) {
                        mon17.setSelected(true)
                    } else mon17.setSelected(false)
                }
                R.id.mon18 -> {
                    this.time = this.time + ",mon18"
                    if (!mon18.isSelected) {
                        mon18.setSelected(true)
                    } else mon18.setSelected(false)
                }
                R.id.mon19 -> {
                    this.time = this.time + ",mon19"
                    if (!mon19.isSelected) {
                        mon19.setSelected(true)
                    } else mon19.setSelected(false)
                }
                R.id.mon20 -> {
                    this.time = this.time + ",mon20"
                    if (!mon20.isSelected) {
                        mon20.setSelected(true)
                    } else mon20.setSelected(false)
                }
                R.id.mon21 -> {
                    this.time = this.time + ",mon21"
                    if (!mon21.isSelected) {
                        mon21.setSelected(true)
                    } else mon21.setSelected(false)
                }
                R.id.mon22 -> {
                    this.time = this.time + ",mon22"
                    if (!mon22.isSelected) {
                        mon22.setSelected(true)
                    } else mon22.setSelected(false)
                }
                //화요일
                R.id.tue10 -> {
                    this.time = this.time + ",tue10"
                    if (!tue10.isSelected) {
                        tue10.setSelected(true)
                    } else tue10.setSelected(false)
                }
                R.id.tue11 -> {
                    this.time = this.time + ",tue11"
                    if (!tue11.isSelected) {
                        tue11.setSelected(true)
                    } else tue11.setSelected(false)
                }
                R.id.tue12 -> {
                    this.time = this.time + ",tue12"
                    if (!tue12.isSelected) {
                        tue12.setSelected(true)
                    } else tue12.setSelected(false)
                }
                R.id.tue13 -> {
                    this.time = this.time + ",tue13"
                    if (!tue13.isSelected) {
                        tue13.setSelected(true)
                    } else tue13.setSelected(false)
                }
                R.id.tue14 -> {
                    this.time = this.time + ",tue14"
                    if (!tue14.isSelected) {
                        tue14.setSelected(true)
                    } else tue14.setSelected(false)
                }
                R.id.tue15 -> {
                    this.time = this.time + ",tue15"
                    if (!tue15.isSelected) {
                        tue15.setSelected(true)
                    } else tue15.setSelected(false)
                }
                R.id.tue16 -> {
                    this.time = this.time + ",tue16"
                    if (!tue16.isSelected) {
                        tue16.setSelected(true)
                    } else tue16.setSelected(false)
                }
                R.id.tue17 -> {
                    this.time = this.time + ",tue17"
                    if (!tue17.isSelected) {
                        tue17.setSelected(true)
                    } else tue17.setSelected(false)
                }
                R.id.tue18 -> {
                    this.time = this.time + ",tue18"
                    if (!tue18.isSelected) {
                        tue18.setSelected(true)
                    } else tue18.setSelected(false)
                }
                R.id.tue19 -> {
                    this.time = this.time + ",tue19"
                    if (!tue19.isSelected) {
                        tue19.setSelected(true)
                    } else tue19.setSelected(false)
                }
                R.id.tue20 -> {
                    this.time = this.time + ",tue20"
                    if (!tue20.isSelected) {
                        tue20.setSelected(true)
                    } else tue20.setSelected(false)
                }
                R.id.tue21 -> {
                    this.time = this.time + ",tue21"
                    if (!tue21.isSelected) {
                        tue21.setSelected(true)
                    } else tue21.setSelected(false)
                }
                R.id.tue22 -> {
                    this.time = this.time + ",tue22"
                    if (!tue22.isSelected) {
                        tue22.setSelected(true)
                    } else tue22.setSelected(false)
                }
                // 수요일
                R.id.wed10 -> {
                    this.time = this.time + ",wed10"
                    if (!wed10.isSelected) {
                        wed10.setSelected(true)
                    } else wed10.setSelected(false)
                }
                R.id.wed11 -> {
                    this.time = this.time + ",wed11"
                    if (!wed11.isSelected) {
                        wed11.setSelected(true)
                    } else wed11.setSelected(false)
                }
                R.id.wed12 -> {
                    this.time = this.time + ",wed12"
                    if (!wed12.isSelected) {
                        wed12.setSelected(true)
                    } else wed12.setSelected(false)
                }
                R.id.wed13 -> {
                    this.time = this.time + ",wed13"
                    if (!wed13.isSelected) {
                        wed13.setSelected(true)
                    } else wed13.setSelected(false)
                }
                R.id.wed14 -> {
                    this.time = this.time + ",wed14"
                    if (!wed14.isSelected) {
                        wed14.setSelected(true)
                    } else wed14.setSelected(false)
                }
                R.id.wed15 -> {
                    this.time = this.time + ",wed15"
                    if (!wed15.isSelected) {
                        wed15.setSelected(true)
                    } else wed15.setSelected(false)
                }
                R.id.wed16 -> {
                    this.time = this.time + ",wed16"
                    if (!wed16.isSelected) {
                        wed16.setSelected(true)
                    } else wed16.setSelected(false)
                }
                R.id.wed17 -> {
                    this.time = this.time + ",wed17"
                    if (!wed17.isSelected) {
                        wed17.setSelected(true)
                    } else wed17.setSelected(false)
                }
                R.id.wed18 -> {
                    this.time = this.time + ",wed18"
                    if (!wed18.isSelected) {
                        wed18.setSelected(true)
                    } else wed18.setSelected(false)
                }
                R.id.wed19 -> {
                    this.time = this.time + ",wed19"
                    if (!wed19.isSelected) {
                        wed19.setSelected(true)
                    } else wed19.setSelected(false)
                }
                R.id.wed20 -> {
                    this.time = this.time + ",wed20"
                    if (!wed20.isSelected) {
                        wed20.setSelected(true)
                    } else wed20.setSelected(false)
                }
                R.id.wed21 -> {
                    this.time = this.time + ",wed21"
                    if (!wed21.isSelected) {
                        wed21.setSelected(true)
                    } else wed21.setSelected(false)
                }
                R.id.wed22 -> {
                    this.time = this.time + ",wed22"
                    if (!wed22.isSelected) {
                        wed22.setSelected(true)
                    } else wed22.setSelected(false)
                }
                //목요일
                R.id.thu10 -> {
                    this.time = this.time + ",thu10"
                    if (!thu10.isSelected) {
                        thu10.setSelected(true)
                    } else thu10.setSelected(false)
                }
                R.id.thu11 -> {
                    this.time = this.time + ",thu11"
                    if (!thu11.isSelected) {
                        thu11.setSelected(true)
                    } else thu11.setSelected(false)
                }
                R.id.thu12 -> {
                    this.time = this.time + ",thu12"
                    if (!thu12.isSelected) {
                        thu12.setSelected(true)
                    } else thu12.setSelected(false)
                }
                R.id.thu13 -> {
                    this.time = this.time + ",thu13"
                    if (!thu13.isSelected) {
                        thu13.setSelected(true)
                    } else thu13.setSelected(false)
                }
                R.id.thu14 -> {
                    this.time = this.time + ",thu14"
                    if (!thu14.isSelected) {
                        thu14.setSelected(true)
                    } else thu14.setSelected(false)
                }
                R.id.thu15 -> {
                    this.time = this.time + ",thu15"
                    if (!thu15.isSelected) {
                        thu15.setSelected(true)
                    } else thu15.setSelected(false)
                }
                R.id.thu16 -> {
                    this.time = this.time + ",thu16"
                    if (!thu16.isSelected) {
                        thu16.setSelected(true)
                    } else thu16.setSelected(false)
                }
                R.id.thu17 -> {
                    this.time = this.time + ",thu17"
                    if (!thu17.isSelected) {
                        thu17.setSelected(true)
                    } else thu17.setSelected(false)
                }
                R.id.thu18 -> {
                    this.time = this.time + ",thu18"
                    if (!thu18.isSelected) {
                        thu18.setSelected(true)
                    } else thu18.setSelected(false)
                }
                R.id.thu19 -> {
                    this.time = this.time + ",thu19"
                    if (!thu19.isSelected) {
                        thu19.setSelected(true)
                    } else thu19.setSelected(false)
                }
                R.id.thu20 -> {
                    this.time = this.time + ",thu20"
                    if (!thu20.isSelected) {
                        thu20.setSelected(true)
                    } else thu20.setSelected(false)
                }
                R.id.thu21 -> {
                    this.time = this.time + ",thu21"
                    if (!thu21.isSelected) {
                        thu21.setSelected(true)
                    } else thu21.setSelected(false)
                }
                R.id.thu22 -> {
                    this.time = this.time + ",thu22"
                    if (!thu22.isSelected) {
                        thu22.setSelected(true)
                    } else thu22.setSelected(false)
                }
                //금요일
                R.id.fri10 -> {
                    this.time = this.time + ",fri10"
                    if (!fri10.isSelected) {
                        fri10.setSelected(true)
                    } else fri10.setSelected(false)
                }
                R.id.fri11 -> {
                    this.time = this.time + ",fri11"
                    if (!fri11.isSelected) {
                        fri11.setSelected(true)
                    } else fri11.setSelected(false)
                }
                R.id.fri12 -> {
                    this.time = this.time + ",fri12"
                    if (!fri12.isSelected) {
                        fri12.setSelected(true)
                    } else fri12.setSelected(false)
                }
                R.id.fri13 -> {
                    this.time = this.time + ",fri13"
                    if (!fri13.isSelected) {
                        fri13.setSelected(true)
                    } else fri13.setSelected(false)
                }
                R.id.fri14 -> {
                    this.time = this.time + ",fri14"
                    if (!fri14.isSelected) {
                        fri14.setSelected(true)
                    } else fri14.setSelected(false)
                }
                R.id.fri15 -> {
                    this.time = this.time + ",fri15"
                    if (!fri15.isSelected) {
                        fri15.setSelected(true)
                    } else fri15.setSelected(false)
                }
                R.id.fri16 -> {
                    this.time = this.time + ",fri16"
                    if (!fri16.isSelected) {
                        fri16.setSelected(true)
                    } else fri16.setSelected(false)
                }
                R.id.fri17 -> {
                    this.time = this.time + ",fri17"
                    if (!fri17.isSelected) {
                        fri17.setSelected(true)
                    } else fri17.setSelected(false)
                }
                R.id.fri18 -> {
                    this.time = this.time + ",fri18"
                    if (!fri18.isSelected) {
                        fri18.setSelected(true)
                    } else fri18.setSelected(false)
                }
                R.id.fri19 -> {
                    this.time = this.time + ",fri19"
                    if (!fri19.isSelected) {
                        fri19.setSelected(true)
                    } else fri19.setSelected(false)
                }
                R.id.fri20 -> {
                    this.time = this.time + ",fri20"
                    if (!fri20.isSelected) {
                        fri20.setSelected(true)
                    } else fri20.setSelected(false)
                }
                R.id.fri21 -> {
                    this.time = this.time + ",fri21"
                    if (!fri21.isSelected) {
                        fri21.setSelected(true)
                    } else fri21.setSelected(false)
                }
                R.id.fri22 -> {
                    this.time = this.time + ",fri22"
                    if (!fri22.isSelected) {
                        fri22.setSelected(true)
                    } else fri22.setSelected(false)
                }
                //토요일
                R.id.sat10 -> {
                    this.time = this.time + ",sat10"
                    if (!sat10.isSelected) {
                        sat10.setSelected(true)
                    } else sat10.setSelected(false)
                }
                R.id.sat11 -> {
                    this.time = this.time + ",sat11"
                    if (!sat11.isSelected) {
                        sat11.setSelected(true)
                    } else sat11.setSelected(false)
                }
                R.id.sat12 -> {
                    this.time = this.time + ",sat12"
                    if (!sat12.isSelected) {
                        sat12.setSelected(true)
                    } else sat12.setSelected(false)
                }
                R.id.sat13 -> {
                    this.time = this.time + ",sat13"
                    if (!sat13.isSelected) {
                        sat13.setSelected(true)
                    } else sat13.setSelected(false)
                }
                R.id.sat14 -> {
                    this.time = this.time + ",sat14"
                    if (!sat14.isSelected) {
                        sat14.setSelected(true)
                    } else sat14.setSelected(false)
                }
                R.id.sat15 -> {
                    this.time = this.time + ",sat15"
                    if (!sat15.isSelected) {
                        sat15.setSelected(true)
                    } else sat15.setSelected(false)
                }
                R.id.sat16 -> {
                    this.time = this.time + ",sat16"
                    if (!sat16.isSelected) {
                        sat16.setSelected(true)
                    } else sat16.setSelected(false)
                }
                R.id.sat17 -> {
                    this.time = this.time + ",sat17"
                    if (!sat17.isSelected) {
                        sat17.setSelected(true)
                    } else sat17.setSelected(false)
                }
                R.id.sat18 -> {
                    this.time = this.time + ",sat18"
                    if (!sat18.isSelected) {
                        sat18.setSelected(true)
                    } else sat18.setSelected(false)
                }
                R.id.sat19 -> {
                    this.time = this.time + ",sat19"
                    if (!sat19.isSelected) {
                        sat19.setSelected(true)
                    } else sat19.setSelected(false)
                }
                R.id.sat20 -> {
                    this.time = this.time + ",sat20"
                    if (!sat20.isSelected) {
                        sat20.setSelected(true)
                    } else sat20.setSelected(false)
                }
                R.id.sat21 -> {
                    this.time = this.time + ",sat21"
                    if (!sat21.isSelected) {
                        sat21.setSelected(true)
                    } else sat21.setSelected(false)
                }
                R.id.sat22 -> {
                    this.time = this.time + ",sat22"
                    if (!sat22.isSelected) {
                        sat22.setSelected(true)
                    } else sat22.setSelected(false)
                }

                //일요일
                R.id.sun10 -> {
                    this.time = this.time + ",sun10"
                    if (!sun10.isSelected) {
                        sun10.setSelected(true)
                    } else sun10.setSelected(false)
                }
                R.id.sun11 -> {
                    this.time = this.time + ",sun11"
                    if (!sun11.isSelected) {
                        sun11.setSelected(true)
                    } else sun11.setSelected(false)
                }
                R.id.sun12 -> {
                    this.time = this.time + ",sun12"
                    if (!sun12.isSelected) {
                        sun12.setSelected(true)
                    } else sun12.setSelected(false)
                }
                R.id.sun13 -> {
                    this.time = this.time + ",sun13"
                    if (!sun13.isSelected) {
                        sun13.setSelected(true)
                    } else sun13.setSelected(false)
                }
                R.id.sun14 -> {
                    this.time = this.time + ",sun14"
                    if (!sun14.isSelected) {
                        sun14.setSelected(true)
                    } else sun14.setSelected(false)
                }
                R.id.sun15 -> {
                    this.time = this.time + ",sun15"
                    if (!sun15.isSelected) {
                        sun15.setSelected(true)
                    } else sun15.setSelected(false)
                }
                R.id.sun16 -> {
                    this.time = this.time + ",sun16"
                    if (!sun16.isSelected) {
                        sun16.setSelected(true)
                    } else sun16.setSelected(false)
                }
                R.id.sun17 -> {
                    this.time = this.time + ",sun17"
                    if (!sun17.isSelected) {
                        sun17.setSelected(true)
                    } else sun17.setSelected(false)
                }
                R.id.sun18 -> {
                    this.time = this.time + ",sun18"
                    if (!sun18.isSelected) {
                        sun18.setSelected(true)
                    } else sun18.setSelected(false)
                }
                R.id.sun19 -> {
                    this.time = this.time + ",sun19"
                    if (!sun19.isSelected) {
                        sun19.setSelected(true)
                    } else sun19.setSelected(false)
                }
                R.id.sun20 -> {
                    this.time = this.time + ",sun20"
                    if (!sun20.isSelected) {
                        sun20.setSelected(true)
                    } else sun20.setSelected(false)
                }
                R.id.sun21 -> {
                    this.time = this.time + ",sun21"
                    if (!sun21.isSelected) {
                        sun21.setSelected(true)
                    } else sun21.setSelected(false)
                }
                R.id.sun22 -> {
                    this.time = this.time + ",sun22"
                    if (!sun22.isSelected) {
                        sun22.setSelected(true)
                    } else sun22.setSelected(false)
                }
            }
        }
        selectedTime = this.time

        val time_arr = selectedTime.split(",")
    }


}