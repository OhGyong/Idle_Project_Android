package com.example.Idle_Project.ui.mypage.member_update_page

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.Idle_Project.R
import com.example.Idle_Project.ui.contact_page.ContactViewModel

class Member_Update_Page_Fragment : Fragment() {

    private lateinit var member_update_page_model: MemberUpdateViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        member_update_page_model =
            ViewModelProvider(this).get(MemberUpdateViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_member_update_page, container, false)
//        val textView: TextView = root.findViewById(R.id.text_anno)
//        member_update_page_model.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }
}