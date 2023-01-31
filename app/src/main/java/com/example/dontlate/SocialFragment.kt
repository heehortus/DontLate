package com.example.dontlate

import android.R
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dontlate.databinding.FragmentSocialBinding


class SocialFragment : Fragment() {

    //데이터 예제
    private val board : List<board> = listOf(
        board("약속 예시 1번입니다.", "노원구 광장", "1.31 (화)", "4", "6", "6" ),
        board("약속 예시 1번입니다.", "노원구 광장", "1.31 (화)", "4", "6", "6" ),
        board("약속 예시 1번입니다.", "노원구 광장", "1.31 (화)", "4", "6", "6" ),
        board("약속 예시 1번입니다.", "노원구 광장", "1.31 (화)", "4", "6", "6" ),
        board("약속 예시 1번입니다.", "노원구 광장", "1.31 (화)", "4", "6", "6" ),

    )

    lateinit var binding : FragmentSocialBinding

    // 회원 정보
    lateinit var user_id : String
    lateinit var user_name : String
    lateinit var user_image : String

    // 폰트 사이즈
    var font : Float = 16F


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSocialBinding.inflate(inflater, container, false)
        val adapter = BoardListAdapter(board)
        binding.recyclerBoard.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtonOnClick()

        /*
         MainActivity에서 넘어온 데이터를 String으로 변환
          --> 로그인한 회원 정보 업데이트
         */
        var bundle = arguments
        user_id = bundle?.getString("user_id").toString()
        user_name = bundle?.getString("user_name").toString()
        user_image = bundle?.getString("user_image").toString()
        //font = bundle?.getFloat("fontSize")!!.toFloat()

        Toast.makeText(getActivity(), user_id, Toast.LENGTH_SHORT).show()
    }

    private fun initButtonOnClick() {
        binding.root.run {
            binding.s13Fab.setOnClickListener {
                // FAB Click 이벤트 처리 구간
                val intent = Intent(getActivity(), social14::class.java)
                intent.putExtra("user_id", user_id)
                startActivity(intent)
            }

            binding.s13NotiBtn.setOnClickListener {
                val intent = Intent(getActivity(), social41::class.java)
                intent.putExtra("user_id", user_id)
                startActivity(intent)
            }

            binding.keyword1.setOnClickListener {
                binding.keyword1.setClickable(true)
                binding.keyword2.setClickable(false)
                binding.keyword3.setClickable(false)
                binding.keyword4.setClickable(false)
                binding.keyword5.setClickable(false)

            }

            binding.keyword2.setOnClickListener {  }

            binding.keyword3.setOnClickListener {  }

            binding.keyword4.setOnClickListener {  }

            binding.keyword5.setOnClickListener {  }

        }
    }

}