package com.example.dontlate

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText


class AccountActivity : AppCompatActivity() {

    lateinit var backBtn: Button
    lateinit var editBtn: Button

    // 로그인 정보 받아오기 : 데이터베이스
    lateinit var userDbManager : userDBManager
    lateinit var sqlitedb: SQLiteDatabase

    //폰트 크기 변형
    lateinit var nameText: TextView
    lateinit var idText: TextView
    lateinit var pwText: TextView
    lateinit var accountName: TextInputEditText
    lateinit var accountId: TextInputEditText
    lateinit var accountPw: TextInputEditText

    //회원 탈퇴 : 팝업 설정
    lateinit var quitBtn: Button
    var dialog : CustomDialog? = null

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        //위젯 아이디 값 가져오기
        backBtn = findViewById(R.id.backBtnA)
        editBtn = findViewById(R.id.editBtn)

        nameText = findViewById(R.id.nameText)
        idText = findViewById(R.id.idText)
        pwText = findViewById(R.id.passwordText)
        accountName = findViewById(R.id.accountName)
        accountId = findViewById(R.id.accountId)
        accountPw = findViewById(R.id.accountPw)

        // 로그인 정보 받아오기
        val intent = intent
        val user_id = intent.getStringExtra("user_id").toString()

        // 데이터베이스 연결
        userDbManager = userDBManager(this@AccountActivity, "user_info", null, 1)
        var cursor : Cursor

        //일치하는 아이디의 데이터베이스 값 받아오기
        sqlitedb = userDbManager.readableDatabase
        cursor = sqlitedb.rawQuery("SELECT * FROM user_info WHERE ID = '$user_id';", null)

        while (cursor.moveToNext()) {
            //회원 정보 반영
            accountName.setText(cursor.getString(cursor.getColumnIndex("name")).toString())
            accountId.setText(cursor.getString(cursor.getColumnIndex("ID")).toString())
            accountPw.setText(cursor.getString(cursor.getColumnIndex("password")).toString())
        }

        sqlitedb.close()


        //회원 탈퇴 : 팝업 설정
        dialog = CustomDialog(this)
        quitBtn = findViewById(R.id.quitBtn)

        //회원 탈퇴
        quitBtn.setOnClickListener{
            dialog!!.start("정말 탈퇴하시겠어요?", 1, 2, this@AccountActivity)
        }

        //돌아가기 버튼 클릭 리스너
        backBtn.setOnClickListener{
            //액티비티 종료
            finish()
        }


        //수정하기 버튼 클릭 리스너
        editBtn.setOnClickListener{
            //현재 화면 종료, 수정 화면으로 이동
            var intent = Intent(this, EditAccountActivity::class.java)
            intent.putExtra("user_id", user_id)
            startActivity(intent)
            finish()
        }

        //폰트 사이즈 설정 자동화를 위한 텍스트 사이즈 선언
        val font: Float = (application as textApplication).getSize()
        nameText.textSize = font
        idText.textSize = font
        pwText.textSize = font
        accountName.textSize = font
        accountId.textSize = font
        accountPw.textSize = font
        editBtn.textSize = font
        quitBtn.textSize = font
    }

}