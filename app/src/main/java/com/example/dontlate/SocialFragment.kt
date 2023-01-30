package com.example.dontlate

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dontlate.databinding.FragmentSocialBinding


class SocialFragment : Fragment() {

    //데이터 예제
    private val board : List<board> = listOf(
        board("약속 예시 1번입니다.", "노원구 광장", "1.31 (화)", "4", "6" ),
        board("약속 예시 2번입니다.", "노원구 광장", "1.31 (화)", "4", "6" ),
        board("약속 예시 3번입니다.", "노원구 광장", "1.31 (화)", "4", "6" ),
        board("약속 예시 4번입니다.", "노원구 광장", "1.31 (화)", "4", "6" ),
        board("약속 예시 5번입니다.", "노원구 광장", "1.31 (화)", "4", "6" )
    )

    lateinit var binding : FragmentSocialBinding

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
    }

    private fun initButtonOnClick() {
        binding.root.run {
            binding.s13Fab.setOnClickListener {
                // FAB Click 이벤트 처리 구간
                val intent = Intent(getActivity(), social14::class.java)
                startActivity(intent)
            }

            binding.s13NotiBtn.setOnClickListener {

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