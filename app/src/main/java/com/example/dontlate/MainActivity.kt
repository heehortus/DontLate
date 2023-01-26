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

    private fun initBottomNavigation() {
        binding.bottomNavi.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.mainFrameLayout, HomeFragment())
                            .addToBackStack(null)
                            .commit();
                    }

                    R.id.menu_mypage -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.mainFrameLayout, MyPageFragment())
                            .addToBackStack(null).commit()
                    }

                    R.id.menu_social -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.mainFrameLayout, SocialFragment())
                            .addToBackStack(null)
                            .commit()
                    }
                }

                true
            }

            selectedItemId = R.id.menu_home
        }
    }
}