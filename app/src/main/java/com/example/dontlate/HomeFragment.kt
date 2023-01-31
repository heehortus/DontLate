package com.example.dontlate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.dontlate.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    //데이터 예제
    private val home_board : List<home_board> = listOf(
        home_board("신청한 약속","생성한 약속", "약속 예시 1번입니다.", "노원구 광장", "1.31 (화)", "4", "6" )
    )

    lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val adapter = HomeListAdapter(home_board)
        binding.recyclerHome.adapter = adapter
        return binding.root
    }

}