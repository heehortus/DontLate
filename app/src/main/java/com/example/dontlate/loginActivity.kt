package com.example.dontlate

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.idcheck_popup.*

class loginActivity : AppCompatActivity() {

    // 기본 버튼 선언
    lateinit var backBtn: Button
    lateinit var startBtn: Button

    // 로그인 기능 구현
    lateinit var userDbManager : userDBManager
    lateinit var sqlitedb: SQLiteDatabase
    lateinit var idInput : TextInputEditText
    lateinit var passwordInput : TextInputEditText

    // 팝업 다이얼로그
    var dialog : CustomDialog? = null

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        backBtn = findViewById(R.id.backBtnA)
        startBtn = findViewById(R.id.startBtn)
        idInput = findViewById(R.id.idInput)
        passwordInput = findViewById(R.id.passwordInput)

        // 팝업 다이얼로그 선언
        dialog = CustomDialog(this)


        // 데이터베이스 연결
        userDbManager = userDBManager(this@loginActivity, "user_info", null, 1)
        var cursor : Cursor

        // 시작하기 버튼
        startBtn.setOnClickListener{
            var str_ID : String = idInput.text.toString()
            var str_password : String = passwordInput.text.toString()
            var user_name : String
            var user_id : String
            var user_image : String? = null
            var pwCheck : String
            var existentID = false // 존재하는 ID 여부 판단

            if(str_ID.isEmpty()) { // 아이디 입력창이 비어있을 경우
                dialog!!.start("아이디를 입력하세요.", 1, 3, this@loginActivity)
                return@setOnClickListener
            }

            if(str_password.isEmpty()) { // 비밀번호 입력창이 비어있을 경우
                dialog!!.start("비밀번호를 입력하세요.", 1, 3, this@loginActivity)
                return@setOnClickListener
            }

            sqlitedb = userDbManager.readableDatabase
            cursor = sqlitedb.rawQuery("SELECT ID FROM user_info;", null)

            // Database 내 입력한 아이디가 존재하는지 여부 판단
            while (cursor.moveToNext()) {
                user_id = cursor.getString(cursor.getColumnIndex("ID")).toString()

                if(str_ID == user_id) existentID = true
            }

            if(existentID) { // 존재하는 아이디라면 비밀번호 비교를 통해 로그인 시도

                cursor = sqlitedb.rawQuery("SELECT * FROM user_info WHERE ID = '$str_ID';", null)

                while (cursor.moveToNext()) {
                    user_id = cursor.getString(cursor.getColumnIndex("ID")).toString()
                    pwCheck = cursor.getString(cursor.getColumnIndex("password")).toString()
                    user_name = cursor.getString(cursor.getColumnIndex("name")).toString()
                    user_image = cursor.getString(cursor.getColumnIndex("profile")).toString()

                    if (pwCheck == str_password) {
                        var intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("user_id", user_id)
                        intent.putExtra("user_name", user_name)
                        intent.putExtra("user_image", user_image)
                        intent.putExtra("fontSize", 16F)
                        intent.putExtra("selectedItem", "home")
                        startActivity(intent)
                    } else {
                        dialog!!.start("비밀번호를 잘못 입력하였습니다.", 1, 3, this@loginActivity)
                    }
                }
            } else {
                dialog!!.start("존재하지 않는 ID입니다.", 1, 3, this@loginActivity)
            }

            sqlitedb.close()
            cursor.close()
        }


        // 뒤로 가기 버튼
        backBtn.setOnClickListener{
            var intent = Intent(this, StartupActivity::class.java)
            startActivity(intent)
        }
    }
}