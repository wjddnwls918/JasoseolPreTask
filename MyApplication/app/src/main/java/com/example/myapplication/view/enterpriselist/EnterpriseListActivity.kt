package com.example.myapplication.view.enterpriselist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class EnterpriseListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: EnterpriseListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(EnterpriseListViewModel::class.java)

        initToolbar()

        initRecyclerView()
    }

    fun initRecyclerView() {

        viewModel.getAllInfo()

        val adapter: EnterpriseListAdapter =
            EnterpriseListAdapter(viewModel.list)
        binding.rvMain.adapter = adapter

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
