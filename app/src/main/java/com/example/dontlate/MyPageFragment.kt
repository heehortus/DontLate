package com.example.dontlate

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dontlate.databinding.FragmentMyPageBinding

class MyPageFragment : Fragment() {

    lateinit var binding : FragmentMyPageBinding

    //팝업 창
    var dialog : CustomDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtonOnClick()
    }

    //버튼 클릭 리스너
    private fun initButtonOnClick() {
        binding.root.run {

            binding.accountBtn.setOnClickListener{
                val intent = Intent(getActivity(), AccountActivity::class.java)
                startActivity(intent)
            }

            binding.historyBtn.setOnClickListener{
                val intent = Intent(getActivity(), HistoryActivity::class.java)
                startActivity(intent)
            }

            binding.settingBtn.setOnClickListener{
                val intent = Intent(getActivity(), SettingActivity::class.java)
                startActivity(intent)
            }
        }
    }





}