package com.example.dontlate

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.idcheck_popup.*
import java.util.regex.Pattern


class joinActivity : AppCompatActivity() {

    lateinit var backBtn: Button
    lateinit var loginBtn: Button

    // 회원가입 기능 구현
    lateinit var userDbManager: userDBManager
    lateinit var personnelDBManager: personnelDBManager
    lateinit var sqlitedb: SQLiteDatabase
    lateinit var startBtn: Button
    lateinit var idInput : TextInputEditText
    lateinit var passwordInput : TextInputEditText
    lateinit var nameInput : TextInputEditText

    // 중복 확인
    lateinit var checkBtn: AppCompatButton
    var use : Int = 0 // 중복 확인 버튼 사용 유무 판단
    var validate : Boolean = false // 아이디 중복 확인 식별자

    // 팝업 다이얼로그
    var dialog : CustomDialog? = null


    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        // 기본 버튼 선언
        backBtn = findViewById(R.id.backBtnA)
        loginBtn = findViewById(R.id.loginBtn)

        // 회원가입 기능 구현
        startBtn = findViewById(R.id.startBtn)
        idInput = findViewById(R.id.idInput)
        passwordInput = findViewById(R.id.passwordInput)
        nameInput = findViewById(R.id.nameInput)

        //중복 확인 버튼
        checkBtn = findViewById(R.id.checkBtn)

        // 팝업 다이얼로그 선언
        dialog = CustomDialog(this)


        /**
         * 특수문자 입력 제한 : Database 형성 시 특수문자가 포함되면 형성할 수 없음
         *    - 아이디, 이름 특수문자 입력 불가
         */
        idInput.setFilters(arrayOf(InputFilter { source, start, end, dest, dstart, dend ->
            val ps: Pattern =
                Pattern.compile("^[a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ\\u318D\\u119E\\u11A2\\u2022\\u2025a\\u00B7\\uFE55]+$")
            if (source == "" || ps.matcher(source).matches()) {
                return@InputFilter source
            }
            dialog!!.start("특수문자는 입력할 수 없습니다.", 1, 3, this@joinActivity)
            ""
        }, LengthFilter(10)))

        nameInput.setFilters(arrayOf(InputFilter { source, start, end, dest, dstart, dend ->
            val ps: Pattern =
                Pattern.compile("^[a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ\\u318D\\u119E\\u11A2\\u2022\\u2025a\\u00B7\\uFE55]+$")
            if (source == "" || ps.matcher(source).matches()) {
                return@InputFilter source
            }
            dialog!!.start("특수문자는 입력할 수 없습니다.", 1, 3, this@joinActivity)
            ""
        }, LengthFilter(10)))


        // 데이터베이스 연결
        userDbManager = userDBManager(this@joinActivity, "user_info", null, 1)
        var cursor : Cursor

        checkBtn.setOnClickListener { // 중복 확인 버튼 클릭 리스너
            var str_ID : String = idInput.text.toString()
            var idCheck : String

            if(str_ID.isEmpty()) { // 아이디 입력창이 비어있을 경우 Dialog 형성
                dialog!!.start("아이디를 입력하세요.", 1, 3, this@joinActivity)
                return@setOnClickListener
            }

            sqlitedb = userDbManager.readableDatabase
            cursor = sqlitedb.rawQuery("SELECT * FROM user_info;", null)

            while (cursor.moveToNext()) {
                idCheck = cursor.getString(cursor.getColumnIndex("ID")).toString()

                if (str_ID == idCheck) {
                    // Database 내 원하는 아이디를 사용하는 회원이 존재하지 않을 경우 validate = true 처리
                    validate = false
                    break
                } else
                    validate = true
            }

            if (validate) { // 중복 확인을 통해 사용 가능한 ID임이 판단되었다면,
                checkBtn.setBackgroundDrawable(getDrawable(R.drawable.btn_clicked))
                checkBtn.text = "확인 완료"
                checkBtn.setTextColor(Color.parseColor("#5F893E"))
                dialog!!.start("사용 가능한 ID입니다.", 1, 3, this@joinActivity)
                use = 1 // 중복 확인 버튼 사용 체크
                idInput.isFocusable = false
                checkBtn.isEnabled = false
            } else {
                dialog!!.start("이미 사용 중인 ID입니다.", 1, 1, this@joinActivity)
            }

            cursor.close()
            sqlitedb.close()
            userDbManager.close()
        }

        //시작 버튼 리스너 설정
        startBtn.setOnClickListener{
            var str_name : String = nameInput.text.toString()
            var str_ID : String = idInput.text.toString()
            var str_password : String = passwordInput.text.toString()
            val uri : Uri = Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(R.drawable.profile))
                .appendPath(resources.getResourceTypeName(R.drawable.profile))
                .appendPath(resources.getResourceEntryName(R.drawable.profile))
                .build()

            sqlitedb = userDbManager.writableDatabase
            sqlitedb.execSQL("UPDATE user_info SET profile = '${uri}' WHERE ID = '${str_ID}'")
            sqlitedb.close()

            if(str_ID.isEmpty()) { // 아이디 입력창이 비어있을 경우 회원가입 불가
                dialog!!.start("아이디를 입력하세요.", 1, 3, this@joinActivity)
                return@setOnClickListener
            }

            if(str_password.isEmpty()) { // 비밀번호 입력창이 비어있을 경우 회원가입 불가
                dialog!!.start("비밀번호를 입력하세요.", 1, 3, this@joinActivity)
                return@setOnClickListener
            }

            if(str_name.isEmpty()) { // 닉네임 입력창이 비어있을 경우 회원가입 불가
                dialog!!.start("닉네임을 입력하세요.", 1, 3, this@joinActivity)
                return@setOnClickListener
            }

            sqlitedb = userDbManager.writableDatabase
            if(checkBtn.text == "확인 완료" && use == 1) {
                sqlitedb.execSQL("INSERT INTO user_info VALUES ('" + str_name + "', '"
                        + str_ID + "', '" + str_password + "', '" + uri + "');")
                sqlitedb.close()

                /**
                 * 개인 데이터를 저장할 Database 생성 - 약속 관련 Data 저장
                 * DB 생성 시, 초기 데이터가 존재하지 않으면 테이블 생성 X
                 * 'example' 초기 데이터로 생성 후, 추후 삭제 예정
                 */
                personnelDBManager = personnelDBManager(this@joinActivity, str_ID, null, 1)
                sqlitedb = personnelDBManager.writableDatabase
                sqlitedb.execSQL("INSERT INTO $str_ID VALUES ('example', 'example', 'example', 'example', 'example', " +
                        "'example', 'example')")
                Toast.makeText(this@joinActivity, "가입되었습니다.", Toast.LENGTH_SHORT).show()

                var intent = Intent(this, loginActivity::class.java)
                startActivity(intent)

                sqlitedb.close()
                userDbManager.close()
                personnelDBManager.close()
            } else {
                dialog!!.start("중복 확인을 해 주세요.", 1, 3, this@joinActivity)
            }
        }

        // 돌아가기 버튼 클릭 리스너 설정
        backBtn.setOnClickListener{
            var intent = Intent(this, StartupActivity::class.java)
            startActivity(intent)
        }

        // 로그인 버튼 클릭 리스너 설정
        loginBtn.setOnClickListener{
            var intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * @param uri: data에서 content 형태로 받은 Uri
     *  다른 Activity 혹은 Fragment에서 활용하기 위해 Real Path를 담은 Uri 생성 함수
     */
    fun getRealPathFromURI (uri : Uri) : String {
        val buildName = Build.MANUFACTURER
        if(buildName.equals("Xiaomi")) {
            return uri.path!!
        }
        var columnIndex = 0
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(uri, proj, null, null, null)
        if(cursor!!.moveToFirst()) {
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        val result = cursor.getString(columnIndex)
        cursor.close()
        return result
    }
}