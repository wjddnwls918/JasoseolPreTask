package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        //툴바 초기화
        initToolbar()

        //리사이클러 뷰 초기화
        initRecyclerView()
    }

    fun initRecyclerView() {

        //데이터 로딩
        viewModel.getAllInfo()
        
        //어뎁터 적용
        val adapter: MainAdapter = MainAdapter(viewModel.list)
        binding.rvMain.adapter = adapter

        //레이아웃 매니저 적용
        val lm = LinearLayoutManager(this)
        binding.rvMain.layoutManager = lm

    }

    fun initToolbar() {
        setSupportActionBar(binding.tbMain);

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_chevron_left_black_24dp)
    }

}
