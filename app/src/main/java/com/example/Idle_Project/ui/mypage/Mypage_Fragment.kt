package com.example.Idle_Project.ui.mypage

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.Idle_Project.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Mypage_Fragment : Fragment() {


    // 1. activity_main.xml 에 존재하는 viewPager2 뷰 객체 초기화를 액티비티 lifecycle에 맞게 지연시킴
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_mypage, container, false)

        // 2. 초기화 지연시킨 viewPager2 객체를 여기서 초기화함
        viewPager2 = root.findViewById(R.id.viewPager2)

        // 3. viewPager2 뷰 객체에 어댑터 적용하기
        viewPager2.adapter = Mypage_ViewPageAdapter(this)

        val tabs: TabLayout = root.findViewById(R.id.tabs)
        TabLayoutMediator(tabs, viewPager2) { tab, position ->
            tab.customView = LayoutInflater.from(context).inflate(R.layout.tab_layout, null) as TextView
            run {
                if(position == 0){
                    (tab.customView as TextView).text = "회원정보수정"
                }else if(position == 1 ){
                    (tab.customView as TextView).text = "포인트현황"
                }else if(position == 2 ){
                    (tab.customView as TextView).text = "내아이디어"
                }else if(position == 3 ){
                    (tab.customView as TextView).text = "관심사업"
                }
            }
        }.attach()

        tabs.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {
                override fun onTabReselected(p0: TabLayout.Tab?) {
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    if (tab?.customView is TextView) {
//                        tab?.customView?.setBackgroundColor(0xFFECEAEA.toInt())
                        tab.customView?.setBackgroundColor(0xFFECEAEA.toInt())
                        (tab.customView as TextView).setTextColor(Color.BLACK)
                    }
                }

                override fun onTabSelected(tab: TabLayout.Tab) {
                    if (tab.customView is TextView) {
                        Log.e("touch","sdds")
                        //(tab.customView as TextView).background = ColorDrawable(Color.RED)
                        tab.customView?.setBackgroundColor(0xFF8345F1.toInt())
                        (tab.customView as TextView).setTextColor(Color.WHITE)
                    }
                    tab.customView?.setBackgroundColor(Color.BLACK)
                }
            })

        return root
    }
}