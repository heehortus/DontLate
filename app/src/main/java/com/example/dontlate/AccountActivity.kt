package com.example.dontlate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class AccountActivity : AppCompatActivity() {

    lateinit var backBtn: Button
    lateinit var editBtn: Button

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        //회원 탈퇴 : 팝업 설정
        dialog = CustomDialog(this)
        quitBtn = findViewById(R.id.quitBtn)

        quitBtn.setOnClickListener{
            dialog!!.start("정말 탈퇴하시겠어요?", 1, 3, this@AccountActivity)
        }

        backBtn = findViewById(R.id.backBtnA)
        editBtn = findViewById(R.id.editBtn)

        //폰트 사이즈 적용
        nameText = findViewById(R.id.nameText)
        idText = findViewById(R.id.idText)
        pwText = findViewById(R.id.passwordText)
        accountName = findViewById(R.id.accountName)
        accountId = findViewById(R.id.accountId)
        accountPw = findViewById(R.id.accountPw)


        backBtn.setOnClickListener{
            var intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }

        editBtn.setOnClickListener{
            var intent = Intent(this, EditAccountActivity::class.java)
            startActivity(intent)
        }

        //폰트 사이즈 설정
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