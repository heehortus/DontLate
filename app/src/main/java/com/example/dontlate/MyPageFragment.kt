package com.example.dontlate

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.dontlate.databinding.FragmentMyPageBinding
import kotlinx.android.synthetic.main.activity_my_page.*
import java.io.File


class MyPageFragment : Fragment() {

    lateinit var binding : FragmentMyPageBinding

    // 회원 정보
    lateinit var user_id : String
    lateinit var user_name : String
    lateinit var user_image : String

    // 폰트 사이즈
    var font : Float = 16F

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMyPageBinding.inflate(inflater, container, false)
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
        font = bundle?.getFloat("fontSize")!!.toFloat()

        name.text = "$user_name 님"

        GlideApp.with(this@MyPageFragment)
            .load(user_image)
            .apply(RequestOptions.centerCropTransform().circleCrop())
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(img_user)

        // 폰트 사이즈 변경
        accountBtn.textSize = font
        historyBtn.textSize = font
        settingBtn.textSize = font
        version.textSize = font
        versionInfo.textSize = font
        logoutBtn.textSize = font
    }

    // 버튼 클릭 리스너 - 이동할 페이지에 로그인한 유저 정보를 담은 user_id 값 전달
    private fun initButtonOnClick() {
        binding.root.run {

            binding.accountBtn.setOnClickListener{
                val intent = Intent(getActivity(), AccountActivity::class.java)
                intent.putExtra("user_id", user_id)
                startActivity(intent)
            }

            binding.historyBtn.setOnClickListener{
                val intent = Intent(getActivity(), HistoryActivity::class.java)
                intent.putExtra("user_id", user_id)
                startActivity(intent)
            }

            binding.settingBtn.setOnClickListener{
                val intent = Intent(getActivity(), SettingActivity::class.java)
                intent.putExtra("user_id", user_id)
                startActivity(intent)
            }
        }
    }
    


}