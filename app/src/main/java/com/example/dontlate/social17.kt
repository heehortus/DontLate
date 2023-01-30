package com.example.dontlate

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_join.*
import java.util.*

class social17 : AppCompatActivity() {

    private lateinit var ivtcode: TextView
    private lateinit var inviteCode : String

    private lateinit var nextBtn: Button
    private lateinit var publicBtn: Button
    private lateinit var privateBtn: Button
    private lateinit var lctBtn: Button
    private lateinit var backBtn: ImageButton
    private lateinit var dltBtn: ImageButton

    private lateinit var nameInput: EditText
    private lateinit var mentionInput: EditText
    private var public: Boolean = false
    private var private: Boolean = false
    private lateinit var state : String

    private lateinit var person_num : String
    private lateinit var deadline : String

    // 팝업 다이얼로그
    var dialog : CustomDialog? = null

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

        nameInput = findViewById(R.id.s17_name_edt)
        mentionInput = findViewById(R.id.social3_mention_edt)

        // 팝업 다이얼로그 선언
        dialog = CustomDialog(this)


        // 값 받아오기
        var intent = intent
        var place = intent.getStringExtra("place_name")
        if(place != null) lctBtn.text = place

        person_num = intent.getStringExtra("person_num").toString()
        deadline = intent.getStringExtra("deadline").toString()
        Toast.makeText(this@social17, "$person_num/$deadline", Toast.LENGTH_SHORT).show()

        if(lctBtn.text != "") {
            var name : String = intent.getStringExtra("name").toString()
            nameInput.setText(name)
        }


        //초대코드 랜덤생성
        val rnd = Random()
        val code1 = (rnd.nextInt(26) + 97).toChar().toString() //영어 소문자 a-z
        val code2 = (rnd.nextInt(26) + 65).toChar().toString() //영어 대문자 A-Z
        val code3 = (rnd.nextInt(26) + 97).toChar().toString() //영어 소문자 a-z
        val code4 = (rnd.nextInt(26) + 97).toChar().toString() //영어 소문자 a-z
        val code5 = (rnd.nextInt(26) + 65).toChar().toString() //영어 대문자 A-Z
        val code6 = (rnd.nextInt(26) + 97).toChar().toString() //영어 소문자 a-z
        inviteCode = code1 + code2 + code3 + code4 + code5 + code6

        mentionInput.isFocusable = lctBtn.text != ""
        mentionInput.setOnClickListener {
            if(lctBtn.text.toString() == "") {
                dialog!!.start("장소를 선택해 주세요.", 1, 3, this@social17)
                return@setOnClickListener
            }
        }

        nextBtn.setOnClickListener {
            var nameText : String = nameInput.text.toString()
            var placeText : String = lctBtn.text.toString()
            var mentionText : String = mentionInput.text.toString()

            // nextBtn Click 이벤트 처리 구간
            if(nameText.isEmpty()) {
                dialog!!.start("약속명을 입력해 주세요.", 1, 3, this@social17)
                return@setOnClickListener
            }
            if(placeText.isEmpty()) {
                dialog!!.start("장소를 선택해 주세요.", 1, 3, this@social17)
                return@setOnClickListener
            }
            if(mentionText.isEmpty()) {
                dialog!!.start("약속 내용을 입력해 주세요.", 1, 3, this@social17)
                return@setOnClickListener
            }

            if(state == "") {
                dialog!!.start("공개 여부를 선택해 주세요.", 1, 3, this@social17)
                return@setOnClickListener
            }

            val intent = Intent(this@social17, social25::class.java)
            Toast.makeText(this@social17, "$nameText/$place/$mentionText", Toast.LENGTH_SHORT).show()
            Toast.makeText(this@social17, "$person_num/$deadline/$state/$inviteCode", Toast.LENGTH_SHORT).show()
            intent.putExtra("name", nameText)
            intent.putExtra("place", place)
            intent.putExtra("mention", mentionText)
            intent.putExtra("person_num", person_num)
            intent.putExtra("deadline", deadline)
            intent.putExtra("state", state)
            intent.putExtra("inveteCode", inviteCode)
            startActivity(intent)
        }

        backBtn.setOnClickListener{
            // backBtn Click 이벤트 처리 구간
            val intent = Intent(applicationContext, social14::class.java)
            startActivity(intent)
        }

        dltBtn.setOnClickListener {
            // dltBtn Click 이벤트 처리 구간
            finish()
        }

        lctBtn.setOnClickListener {
            // Private Click 이벤트 처리 구간
            if(nameInput.text.toString() == "") {
                dialog!!.start("약속명을 입력해 주세요.", 1, 3, this@social17)
                return@setOnClickListener
            }

            var nameText : String = nameInput.text.toString()

            // lctBtn Click 이벤트 처리 구간
            val intent = Intent(applicationContext, SearchActivity::class.java)
            intent.putExtra("name", nameText)
            intent.putExtra("person_num", person_num)
            intent.putExtra("deadline", deadline)
            startActivity(intent)
        }

        publicBtn.setOnClickListener(PublicClickListener())
        privateBtn.setOnClickListener(PrivateClickListener())
    }


    internal inner class PublicClickListener : View.OnClickListener {
        override fun onClick(v: View) {
            // Private Click 이벤트 처리 구간
            if(mentionInput.text.toString() == "") {
                dialog!!.start("약속 내용을 입력해 주세요.", 1, 3, this@social17)
                return
            }

            // 눌리면
            if (!public) {
                publicBtn.background = getDrawable(R.drawable.social_whitebutton_orangeborder)
                publicBtn.setTextColor(Color.parseColor("#E88B58"))
                public = true
                privateBtn.background = getDrawable(R.drawable.social_whitebutton_grayborder)
                privateBtn.setTextColor(Color.parseColor("#474747"))
                private = false

                state = "public"
                ivtcode.text = ""
                // 다시 누르면
            } else {
                publicBtn.background = getDrawable(R.drawable.social_whitebutton_grayborder)
                publicBtn.setTextColor(Color.parseColor("#474747"))
                public = false

                state = ""
            }
        }
    }

    internal inner class PrivateClickListener : View.OnClickListener {
        override fun onClick(v: View) {
            // Private Click 이벤트 처리 구간
            if(mentionInput.text.toString() == "") {
                dialog!!.start("약속 내용을 입력해 주세요.", 1, 3, this@social17)
                return
            }

            // 눌리면
            if (!private) {
                privateBtn.background = getDrawable(R.drawable.social_whitebutton_orangeborder)
                privateBtn.setTextColor(Color.parseColor("#E88B58"))
                private = true
                publicBtn.background = getDrawable(R.drawable.social_whitebutton_grayborder)
                publicBtn.setTextColor(Color.parseColor("#474747"))
                public = false

                state = "private"
                ivtcode.text = inviteCode
                // 다시 누르면
            } else {
                privateBtn.background = getDrawable(R.drawable.social_whitebutton_grayborder)
                privateBtn.setTextColor(Color.parseColor("#474747"))
                private = false

                state = ""
            }
        }
    }
}