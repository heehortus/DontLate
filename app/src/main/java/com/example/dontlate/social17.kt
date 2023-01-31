package com.example.dontlate

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class social17 : AppCompatActivity() {

    //초대 코드 (자동 생성)
    private lateinit var ivtcode: TextView
    private lateinit var inviteCode : String

    //위젯 선언
    private lateinit var nextBtn: Button
    private lateinit var publicBtn: Button
    private lateinit var privateBtn: Button
    private lateinit var lctBtn: Button
    private lateinit var backBtn: ImageButton
    private lateinit var dltBtn: ImageButton

    private lateinit var edtName : EditText
    private lateinit var edtPlace : Button
    private lateinit var edtMention : EditText
    private lateinit var edtObject : String

    private var usePlaceBtn : Boolean = false

    // 로그인 정보 받아오기 : 데이터베이스
    lateinit var userDbManager : userDBManager
    lateinit var sqlitedb: SQLiteDatabase
    lateinit var str_name : String
    lateinit var str_id : String
    lateinit var str_password : String
    lateinit var imageUri : String

    //정보 수정 시 팝업 제공
    var dialog : CustomDialog? = null

    @SuppressLint("Range")
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

        edtName = findViewById(R.id.s17_name_edt)
        edtPlace = findViewById(R.id.s17_lct_btn)
        edtMention = findViewById(R.id.social3_mention_edt)

        //정보 수정 반영 다이얼로그
        dialog = CustomDialog(this)

        // 로그인 정보 받아오기 - 홈 화면으로 나갈 때 정보 전달
        val intent = intent
        var headID = intent.getStringExtra("headID").toString()

        // 데이터베이스 연결
        userDbManager = userDBManager(this@social17, "user_info", null, 1)
        var cursor : Cursor

        //일치하는 아이디의 데이터베이스 값 받아오기
        sqlitedb = userDbManager.readableDatabase
        cursor = sqlitedb.rawQuery("SELECT * FROM user_info WHERE ID = '$headID';", null)

        while (cursor.moveToNext()) {
            //회원 정보 반영
            str_id = cursor.getString(cursor.getColumnIndex("ID")).toString()
            str_password = cursor.getString(cursor.getColumnIndex("password")).toString()
            str_name = cursor.getString(cursor.getColumnIndex("name")).toString()
            imageUri = cursor.getString(cursor.getColumnIndex("profile")).toString()
        }



        // 이전 화면에서 데이터 넘겨받기
        var total_num = intent.getStringExtra("total_num").toString()
        var deadline = intent.getStringExtra("deadline").toString()
        var place = intent.getStringExtra("place_name").toString()
        var name = intent.getStringExtra("name").toString()
        usePlaceBtn = intent.getBooleanExtra("usePlaceBtn", false)

        if(!usePlaceBtn) edtName.setText("")
        else edtName.setText(name)

        if(edtName.text.toString().isNotEmpty()) {
            edtPlace.text = place
        }
        if (edtPlace.text.toString() == ""){
            edtMention.isFocusable = false
        }


        edtMention.setOnClickListener{
            if(edtPlace.text.toString() == ""){
                dialog!!.start("약속 장소를 선택하세요.", 1, 3, this@social17)
                return@setOnClickListener
            }
        }

        backBtn.setOnClickListener {
            val intent = Intent(this, social14::class.java)
            intent.putExtra("headID", headID)
            intent.putExtra("total_num", total_num)
            intent.putExtra("deadline", deadline)
            startActivity(intent)
        }

        dltBtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user_id", str_id)
            intent.putExtra("user_name", str_name)
            intent.putExtra("user_image", imageUri)
            intent.putExtra("selectedItem", "social")
            startActivity(intent)
        }


        nextBtn.setOnClickListener {
            val intent = Intent(this, social25::class.java)
            if(edtObject == "public") inviteCode = ""

            intent.putExtra("headID", headID)
            intent.putExtra("name", name)
            intent.putExtra("total_num", total_num)
            intent.putExtra("place", place)
            intent.putExtra("mention", edtMention.text.toString())
            intent.putExtra("deadline", deadline)
            intent.putExtra("object", edtObject)
            intent.putExtra("inviteCode", inviteCode)
            startActivity(intent)
        }

        lctBtn.setOnClickListener {
            if(edtName.text.toString() == ""){
                dialog!!.start("약속명을 입력하세요.", 1, 3, this@social17)
                return@setOnClickListener
            }

            val name = edtName.text.toString()
            val intent = Intent(applicationContext, SearchActivity::class.java)
            intent.putExtra("headID", headID)
            intent.putExtra("name", name)
            intent.putExtra("total_num", total_num)
            intent.putExtra("deadline", deadline)
            intent.putExtra("usePlaceBtn", true)
            startActivity(intent)
        }


        //초대 코드 랜덤 생성
        val rnd = Random()
        val code1 = (rnd.nextInt(26) + 97).toChar().toString() //영어 소문자 a-z
        val code2 = (rnd.nextInt(26) + 65).toChar().toString() //영어 대문자 A-Z
        val code3 = (rnd.nextInt(26) + 97).toChar().toString() //영어 소문자 a-z
        val code4 = (rnd.nextInt(26) + 97).toChar().toString() //영어 소문자 a-z
        val code5 = (rnd.nextInt(26) + 65).toChar().toString() //영어 대문자 A-Z
        val code6 = (rnd.nextInt(26) + 97).toChar().toString() //영어 소문자 a-z
        inviteCode = code1 + code2 + code3 + code4 + code5 + code6

        // Public Click 이벤트 처리 구간
        publicBtn.setOnClickListener {
            if(edtMention.text.toString() == ""){
                dialog!!.start("약속 내용을 입력하세요.", 1, 3, this@social17)
                return@setOnClickListener
            }

            // 초대코드 없음
            ivtcode.setText("")

            var num = 0
            num++
            // 눌리면
            if (num % 2 == 1) {
                publicBtn.background = getDrawable(R.drawable.social_whitebutton_orangeborder)
                publicBtn.setTextColor(Color.parseColor("#E88B58"))
                privateBtn.background = getDrawable(R.drawable.social_whitebutton_grayborder)
                privateBtn.setTextColor(Color.parseColor("#474747"))
                edtObject = "public"
                // 다시 누르면
            } else {
                publicBtn.background = getDrawable(R.drawable.social_whitebutton_grayborder)
                publicBtn.setTextColor(Color.parseColor("#474747"))
            }
        }

        // Private Click 이벤트 처리 구간
        privateBtn.setOnClickListener{
            if(edtMention.text.toString() == ""){
                dialog!!.start("약속 내용을 입력하세요.", 1, 3, this@social17)
                return@setOnClickListener
            }

            ivtcode.text = inviteCode

            //버튼 테두리 변경
            var num = 0
            num++
            // 눌리면
            if (num % 2 == 1) {
                privateBtn.background = getDrawable(R.drawable.social_whitebutton_orangeborder)
                privateBtn.setTextColor(Color.parseColor("#E88B58"))
                publicBtn.background = getDrawable(R.drawable.social_whitebutton_grayborder)
                publicBtn.setTextColor(Color.parseColor("#474747"))
                edtObject = "private"

                // 다시 누르면
            } else {
                privateBtn.background = getDrawable(R.drawable.social_whitebutton_grayborder)
                privateBtn.setTextColor(Color.parseColor("#474747"))
            }
        }


    }
}