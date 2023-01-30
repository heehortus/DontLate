package com.example.dontlate

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.Dimension
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import java.io.File


class FontSizeActivity : AppCompatActivity() {

    lateinit var backBtn: Button

    // 로그인 정보 받아오기 : 데이터베이스
    lateinit var userDbManager : userDBManager
    lateinit var sqlitedb: SQLiteDatabase
    lateinit var str_name : String

    //프로필 사진
    lateinit var img_user: ImageView
    lateinit var imageUri: String

    /* 폰트 크기 변경 :
        - sizebar: 크기 변경
        - fontSizeEx: 변경한 폰트 크기 확인 텍스트 뷰
        - manification: 변경한 텍스트 크기 배율 보이기
     */
    lateinit var sizebar: SeekBar
    lateinit var fontSizeEx: TextView
    lateinit var magnification: TextView

    lateinit var nickname : TextView

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_font_size)

        // 회원 정보
        img_user = findViewById(R.id.img_user3)
        img_user.setImageResource(R.drawable.profile)
        nickname = findViewById(R.id.nickname)

        // 뒤로가기 버튼
        backBtn = findViewById(R.id.backBtnF)

        // 폰트 크기 변경
        sizebar = findViewById(R.id.sizebar)
        fontSizeEx = findViewById(R.id.fontSizeEx)
        magnification = findViewById(R.id.magnification)


        // 로그인한 회원 정보 받아오기
        val intent = intent
        val user_id = intent.getStringExtra("user_id").toString()

        // 데이터베이스 연결
        userDbManager = userDBManager(this@FontSizeActivity, "user_info", null, 1)
        var cursor : Cursor

        sqlitedb = userDbManager.readableDatabase
        cursor = sqlitedb.rawQuery("SELECT * FROM user_info WHERE ID = '$user_id';", null)

        while (cursor.moveToNext()) {
            str_name = cursor.getString(cursor.getColumnIndex("name")).toString()
            imageUri = cursor.getString(cursor.getColumnIndex("profile")).toString()
        }
        sqlitedb.close()
        cursor.close()

        /*
            회원 정보 반영 :
            1. 회원이 설정한 프로필 이미지 Uri를 Database에서 불러와 File 형태로 변환 및 적용
            2. 데이터베이스에서 회원 정보를 불러와 각각의 EditText에 반영
         */
        var imageFile = File(imageUri)
        nickname.setText(str_name)

        Glide.with(this)
            .load(imageFile)
            .apply(RequestOptions.centerCropTransform().circleCrop())
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(img_user)
        img_user.scaleType = ImageView.ScaleType.FIT_CENTER


        // 뒤로 가기 버튼 - 설정 화면(activity_setting.xml)으로 이동
        backBtn.setOnClickListener{
            var intent = Intent(this, SettingActivity::class.java)
            intent.putExtra("user_id", user_id)
            startActivity(intent)
        }

        // 폰트 조절 Progress Bar
        val progress: Int = (application as textApplication).getProgress()
        sizebar.progress = progress

        val mag : String = (application as textApplication).getMagnification()
        magnification.text = mag

        // 조절 폰트 적용
        // 폰트 사이즈 설정
        val font: Float = (application as textApplication).getSize()
        nickname.textSize = font
        fontSizeEx.textSize = font
        magnification.textSize = font

        sizebar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                var progress = progress

                /**
                 * 구간을 설정하여 총 7 개의 폰트 사이즈 (10sp to 22sp) 변경 및 적용 가능
                 * - sizebar.progress: 구간에 따른 progress 지정
                 * - fontsizeEx.setTextSize(Dimension.SP, size): 사용자가 선택한 구간에 따라 폰트 사이즈 설정 (sp)
                 * - magnification.text: 폰트 배율 텍스트
                 * - (applicaion as textApplication): 전역 변수 클래스에 각 값을 저장
                 *    >> 다른 클래스에서 받아서 폰트 사이즈를 적용할 수 있음.
                 */
                when(progress){
                    in 0..5 -> {
                        sizebar.progress = 0
                        fontSizeEx.setTextSize(Dimension.SP, 10F)
                        magnification.text = "x 0.7"
                        (application as textApplication).setMagnification("x 0.7")
                        (application as textApplication).setProgress(0)
                        (application as textApplication).setSize(10F)
                    }
                    in 6..15 -> {
                        sizebar.progress = 10
                        fontSizeEx.setTextSize(Dimension.SP, 12F)
                        magnification.text = "x 0.8"
                        (application as textApplication).setMagnification("x 0.8")
                        (application as textApplication).setProgress(10)
                        (application as textApplication).setSize(12F)
                    }
                    in 16..25 -> {
                        sizebar.progress = 20
                        fontSizeEx.setTextSize(Dimension.SP, 14F)
                        magnification.text = "x 0.9"
                        (application as textApplication).setMagnification("x 0.9")
                        (application as textApplication).setProgress(20)
                        (application as textApplication).setSize(14F)
                    }
                    in 26..35 -> {
                        sizebar.progress = 30
                        fontSizeEx.setTextSize(Dimension.SP, 16F)
                        magnification.text = "x 1.0"
                        (application as textApplication).setMagnification("x 1.0")
                        (application as textApplication).setProgress(30)
                        (application as textApplication).setSize(16F)
                    }
                    in 36..45 -> {
                        sizebar.progress = 40
                        fontSizeEx.setTextSize(Dimension.SP, 18F)
                        magnification.text = "x 1.1"
                        (application as textApplication).setMagnification("x 1.1")
                        (application as textApplication).setProgress(40)
                        (application as textApplication).setSize(18F)
                    }
                    in 46..55 -> {
                        sizebar.progress = 50
                        fontSizeEx.setTextSize(Dimension.SP, 20F)
                        magnification.text = "x 1.2"
                        (application as textApplication).setMagnification("x 1.2")
                        (application as textApplication).setProgress(50)
                        (application as textApplication).setSize(20F)
                    }
                    in 56..60 -> {
                        sizebar.progress = 60
                        fontSizeEx.setTextSize(Dimension.SP, 22F)
                        magnification.text = "x 1.3"
                        (application as textApplication).setMagnification("x 1.3")
                        (application as textApplication).setProgress(60)
                        (application as textApplication).setSize(22F)
                    }
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                // TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                // TODO("Not yet implemented")
            }
        })
    }
}