package com.example.dontlate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dontlate.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    //프래그먼트, 뷰 바인딩
    private lateinit var binding : ActivityMainBinding

    //회원 정보 받아오기
    lateinit var user_id : String
    lateinit var user_name : String
    lateinit var user_image : String
    var fontSize : Float = 16F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 로그인 정보 받아오기
        val intent = intent
        user_id = intent.getStringExtra("user_id").toString()
        user_name = intent.getStringExtra("user_name").toString()
        user_image = intent.getStringExtra("user_image").toString()
        fontSize = intent.getFloatExtra("fontSize", 16F)

        initBottomNavigation()
    }

    /**
     * 네비게이션 초기화 함수
     * 각 Fragment에 유저 정보를 전달하기 위한 코드 :
     *
     *      var (FragmentName) = (FragmentName)()
            var bundle = Bundle()

            bundle.putString("user_id", user_id)
            bundle.putString("user_name", user_name)
            myPageFragment.arguments = bundle
     *
     * user_id 정보를 전달하여 각 fragment에서 db 활용
     * */
    private fun initBottomNavigation() {
        binding.bottomNavi.run {
            var bundle = Bundle()

            bundle.putString("user_id", user_id)
            bundle.putString("user_name", user_name)
            bundle.putString("user_image", user_image)
            bundle.putFloat("fontSize", fontSize)

            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    //네비게이션 홈 버튼 클릭
                    R.id.menu_home -> {
                        var homeFragment = HomeFragment()
                        homeFragment.arguments = bundle // fragment의 arguments에 데이터를 담은 bundle을 넘겨줌.

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.mainFrameLayout, homeFragment)
                            .addToBackStack(null).commit();
                    }

                    //네비게이션 마이 페이지 버튼 클릭
                    R.id.menu_mypage -> {
                        var myPageFragment = MyPageFragment()
                        myPageFragment.arguments = bundle // fragment의 arguments에 데이터를 담은 bundle을 넘겨줌.

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.mainFrameLayout, myPageFragment)
                            .addToBackStack(null).commit()
                    }

                    //네비게이션 약속 생성 버튼 클릭
                    R.id.menu_social -> {
                        var socialFragment = SocialFragment()
                        socialFragment.arguments = bundle // fragment의 arguments에 데이터를 담은 bundle을 넘겨줌.

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.mainFrameLayout, socialFragment)
                            .addToBackStack(null).commit()
                    }
                }

                true
            }

            /*
                각 요청에 따라 보이는 화면을 다르게 설정
                1) Home 화면으로 넘어와야 할 경우: Intent 값으로 selectedItem = "home" 전달
                2) myPage 화면으로 넘어와야 할 경우: Intent 값으로 selectedItem = "mypage" 전달
                3) social 화면으로 넘어와야 할 경우: Intent 값으로 selectedItem = "social" 전달
             */

            var selectedItem : String = intent.getStringExtra("selectedItem").toString()
            if(selectedItem == "home") selectedItemId = R.id.menu_home
            else if (selectedItem == "mypage") selectedItemId = R.id.menu_mypage
            else if (selectedItem == "social") selectedItemId = R.id.menu_social

        }
    }
}