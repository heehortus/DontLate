package com.example.dontlate

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


open class CustomDialog(context: Context) : AppCompatActivity() {

    private lateinit var context : Context

    private val dialog = Dialog(context)
    private lateinit var body : TextView
    private lateinit var confirm : Button
    private lateinit var cancel : Button
    val Tag = "로그 "

    fun start(bodyMessage: String, mode: Int, dialogMode: Int, context: Context?) {
        /**
         * @param bodyMessage: CustomDialog 내 문장 변경
         * @param dialogMode: Dialog 특성에 따라 dialogMode 선택
         * @param mode: 동일한 Dialog 내 다른 모드 적용 가능 - 버튼 클릭 리스너 등
         * @param context: context
         *
         * 1) dialogMode = 1 : 아이디 중복 체크 - 버튼 한 개 (확인) & 텍스트 한 줄
         * 2) dialogMode = 2 : 회원 탈퇴 - 버튼 두 개 (확인, 취소) & 텍스트 두 줄
         * 3) dialogMode = 3 : 안내 메세지 - 버튼 한 개 (확인) & 텍스트 한 줄
         * 4) dialogMode = 4 : Map 위 도착지 Dialog - 버튼 한 개 & 장소 텍스트 한 줄
         */

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) // 여백 제거

        when(dialogMode) {
            1 -> { // 아이디 중복 체크 : 확인 버튼, 텍스트 두 줄
                dialog.setContentView(R.layout.idcheck_popup)
                body = dialog.findViewById(R.id.mainText3)
                body.text = bodyMessage

                confirm = dialog.findViewById(R.id.checkBtn)

                confirm.setOnClickListener {
                    when(mode) {
                        1 -> {
                            dialog.dismiss()
                        }
                    }
                }
            }

            2 -> { // 회원 탈퇴 다이얼로그 : 확인, 취소 버튼, 텍스트 두 줄
                dialog.setContentView(R.layout.withdrawal_popup)
                body = dialog.findViewById(R.id.mainText2)
                body.text = bodyMessage

                confirm = dialog.findViewById(R.id.checkBtn)
                cancel = dialog.findViewById(R.id.cancelBtn)

                cancel.setOnClickListener {//취소 버튼
                    dialog.dismiss()
                }

                confirm.setOnClickListener {//확인 버튼
                    when(mode) {
                        1 -> {
                            var intent = Intent(context, loginActivity::class.java)
                            context?.startActivity(intent)
                            finish()
                        }
                    }
                }
            }

            3 -> { // 확인 버튼, 텍스트 한 줄
                dialog.setContentView(R.layout.notification_popup)
                body = dialog.findViewById(R.id.mainText4)
                body.text = bodyMessage

                confirm = dialog.findViewById(R.id.checkBtn)

                confirm.setOnClickListener {// 확인 버튼
                    when(mode) {
                        1 -> {
                            dialog.dismiss()
                        }
                    }

                }
            }

            4 -> { // 지도 팝업
                dialog.setContentView(R.layout.map_popup)
                body = dialog.findViewById(R.id.place)
                body.text = bodyMessage

                confirm = dialog.findViewById(R.id.nextBtn)

                confirm.setOnClickListener {
                    when(mode) {
                        1 -> {
                            var intent = Intent(this, social25::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
            }
        }
        dialog.setCancelable(false) //다이얼로그 이외의 화면 터치 시 닫히지 않음
        dialog.show()
    }
}