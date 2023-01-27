package com.example.dontlate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dontlate.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    //프래그먼트, 뷰 바인딩
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
    }

    //네비게이션 초기화 함수
    private fun initBottomNavigation() {
        binding.bottomNavi.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    //네비게이션 홈 버튼 클릭
                    R.id.menu_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.mainFrameLayout, HomeFragment())
                            .addToBackStack(null)
                            .commit();
                    }

                    //네비게이션 마이 페이지 버튼 클릭
                    R.id.menu_mypage -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.mainFrameLayout, MyPageFragment())
                            .addToBackStack(null).commit()
                    }

                    //네비게이션 약속 생성 버튼 클릭
                    R.id.menu_social -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.mainFrameLayout, SocialFragment())
                            .addToBackStack(null)
                            .commit()
                    }
                }

                true
            }

            //기본 값 - 홈으로 설정
            selectedItemId = R.id.menu_home
        }
    }
}