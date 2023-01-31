package com.example.dontlate

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import org.w3c.dom.Text

class SummaryActivity : AppCompatActivity() {

    // 약속 정보 저장 : 데이터베이스
    lateinit var personnelDBManager: personnelDBManager
    lateinit var serverDBManager: serverDBManager
    lateinit var sqlitedb: SQLiteDatabase

    // 로그인 정보 받아오기 : 데이터베이스
    lateinit var userDbManager : userDBManager
    lateinit var str_name : String
    lateinit var str_id : String
    lateinit var str_password : String
    lateinit var imageUri : String

    private lateinit var summaryTitle : TextView
    private lateinit var personnelText : TextView
    private lateinit var dateText : TextView
    private lateinit var placeText : TextView
    private lateinit var inviteCode : TextView
    private lateinit var deadlineText : TextView
    private lateinit var mentionText : EditText

    private lateinit var privateImg : ImageView

    private lateinit var newBtn : Button
    private lateinit var clipboardBtn : Button


    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        // 텍스트 및 버튼 선언
        summaryTitle = findViewById(R.id.summaryTitle)
        personnelText = findViewById(R.id.personnelText)
        dateText = findViewById(R.id.dateText)
        placeText = findViewById(R.id.placeText)
        inviteCode = findViewById(R.id.inviteCode)
        deadlineText = findViewById(R.id.deadlineText)
        mentionText = findViewById(R.id.mentionText)

        privateImg = findViewById(R.id.privateImg)

        newBtn = findViewById(R.id.newBtn)
        clipboardBtn = findViewById(R.id.clipboardBtn)


        // 이전 화면에서 데이터 받아오기
        var intent = intent
        var headID = intent.getStringExtra("headID").toString()
        var title = intent.getStringExtra("name").toString()
        var total_num = intent.getStringExtra("total_num")?.toInt()
        var place = intent.getStringExtra("place").toString()
        var mention = intent.getStringExtra("mention").toString()
        var deadline = intent.getStringExtra("deadline").toString()
        var private = intent.getStringExtra("object").toString()
        var ivtCode = intent.getStringExtra("inviteCode").toString()
        var date = intent.getStringExtra("date").toString()
        var time = intent.getStringExtra("time").toString()


        summaryTitle.text = title
        personnelText.text = "$total_num 명"
        dateText.text = date
        placeText.text = place
        inviteCode.text = ivtCode
        deadlineText.text = deadline
        mentionText.setText(mention)

        if(private == "public") privateImg.visibility = View.GONE

        // 데이터베이스 연결
        userDbManager = userDBManager(this@SummaryActivity, "user_info", null, 1)
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


        newBtn.setOnClickListener {
            // 약속 추가
            personnelDBManager = personnelDBManager(this@SummaryActivity, headID, null, 1)
            sqlitedb = personnelDBManager.writableDatabase
            sqlitedb.execSQL("INSERT INTO $headID VALUES ('$headID', '$headID', '$date', '$title', '$time', '$place', '대기')")
            personnelDBManager.close()

            serverDBManager = serverDBManager(this@SummaryActivity, "server", null, 1)
            sqlitedb = serverDBManager.writableDatabase
            sqlitedb.execSQL("INSERT INTO server VALUES ('$headID', '$date', '$title', '$place', '$deadline', $total_num, '$mention', 1, '대기'," +
                    "'$private', '$ivtCode', null)")
            serverDBManager.close()
            sqlitedb.close()

            // 회원 데이터 넘겨주기
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user_id", str_id)
            intent.putExtra("user_name", str_name)
            intent.putExtra("user_image", imageUri)
            intent.putExtra("selectedItem", "social")
            startActivity(intent)
        }

        clipboardBtn.setOnClickListener {
            var code = inviteCode.text.toString()
            createClipData(code)
            return@setOnClickListener
        }
    }

    // 클립 데이터 생성
    fun createClipData(inviteCode : String) {
        var clipboardManager : ClipboardManager = application.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        var clipData : ClipData = ClipData.newPlainText("invitecode", inviteCode)

        //클립보드에 배치
        clipboardManager.setPrimaryClip(clipData)
        Toast.makeText(this@SummaryActivity, "클립보드에 복사되었습니다.", Toast.LENGTH_SHORT).show()
    }
}