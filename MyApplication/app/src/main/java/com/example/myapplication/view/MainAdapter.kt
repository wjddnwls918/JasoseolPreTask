package com.example.myapplication.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.common.BaseRecyclerVIewAdapter
import com.example.myapplication.databinding.EnterItemBinding
import com.example.myapplication.model.EnterInfo

class MainAdapter(dataSet: MutableList<EnterInfo>) : BaseRecyclerVIewAdapter<EnterInfo, MainAdapter.ViewHolder>(dataSet) {

    override fun onBindView(holder: ViewHolder, position: Int) {
        holder.binding.enter = getItem(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding: EnterItemBinding = EnterItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)

        return ViewHolder(binding)
    }

    class ViewHolder(var binding:EnterItemBinding):RecyclerView.ViewHolder(binding.root)
}