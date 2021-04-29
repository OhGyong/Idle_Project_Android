package com.example.idleProject.ui.notice_cs_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.idleProject.R

class CsData(
    private var cs_num: String? = null,
    private var cs_title: String? = null,
    private var cs_name: String? = null,
    private var cs_date: String? = null
){
    fun getData1(): String? {
        return cs_num
    }

    fun setData1(name: String) {
        this.cs_num = cs_num
    }

    fun getData2(): String? {
        return cs_title
    }

    fun setData2(address: String) {
        this.cs_title = cs_title
    }

    fun getData3(): String? {
        return cs_name
    }

    fun setData3(address: String) {
        this.cs_name = cs_name
    }

    fun getData4(): String? {
        return cs_date
    }

    fun setData4(address: String) {
        this.cs_date = cs_date
    }
}

class CsPageFragment : Fragment() {

    var csList: ArrayList<CsData> = arrayListOf(
        CsData("9", "문의게시판 제목9", "오기용", "2021-04-30"),
        CsData("8", "문의게시판 제목8", "오기용", "2021-04-30"),
        CsData("7", "문의게시판 제목7", "오기용", "2021-04-30"),
        CsData("5", "문의게시판 제목5", "오기용", "2021-04-30"),
        CsData("6", "문의게시판 제목6", "오기용", "2021-04-30"),
        CsData("4", "문의게시판 제목4", "오기용", "2021-04-30"),
        CsData("3", "문의게시판 제목3", "오기용", "2021-04-30"),
        CsData("2", "문의게시판 제목2", "오기용", "2021-04-30"),
        CsData("1", "문의게시판 제목1", "오기용", "2021-04-30")
    )

    private lateinit var csListAdapter: CsPageAdapter
    private var csListView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_cs_page, container, false)
        csListView=view.findViewById(R.id.cs_recycler)

        //문의게시판 등록버튼 눌렀을 때
        val cs_regist_page_bt: Button = view.findViewById<Button>(R.id.cs_regist_page_bt)
        cs_regist_page_bt.setOnClickListener {
            findNavController().navigate(R.id.nav_cs_regist_page)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        csListAdapter = CsPageAdapter(csList)
        csListView?.adapter = csListAdapter
    }
}