package com.example.myapplication.common

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.annotation.NonNull

abstract class BaseRecyclerVIewAdapter<T, VH : RecyclerView.ViewHolder?>(open var dataSet:MutableList<T>?) : RecyclerView.Adapter<VH>()
{
    fun getItem(position: Int): T? {
        return if (dataSet == null) null else dataSet!![position]
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        onBindView(holder as VH, position)
    }

    abstract fun onBindView(holder: VH, position: Int)

    override fun getItemCount(): Int {
        return if (dataSet == null) 0 else dataSet!!.size
    }

    /**
     * Add items.
     *
     * @param items list.
     */
    fun addItems(items: List<T>) {
        if (dataSet == null) {
            dataSet = ArrayList()
        }

        val currentSize = itemCount
        dataSet!!.addAll(items)

        notifyItemRangeInserted(currentSize, items.size)
    }

    /**
     * clear and add items.
     * @param items list.
     */
    fun updateItems(items: List<T>) {
        if (dataSet == null) {
            dataSet = ArrayList()
        }
        dataSet!!.clear()
        notifyDataSetChanged()

        dataSet!!.addAll(items)
        notifyItemRangeChanged(0, items.size)
    }


    /**
     * RemoveAll items.
     */
    fun removeAllItems() {
        if (dataSet != null) {
            dataSet!!.clear()
            notifyDataSetChanged()
        }
    }

    fun removeItem(item: T) {
        val position = getItemPosition(item)

        dataSet!!.removeAt(position)
        notifyItemRemoved(position)
    }

    /**
     * Set items.
     */
    fun setItem(items: MutableList<T>) {
        this.dataSet = items
        notifyDataSetChanged()
    }

    fun getItemPosition(item: T): Int {
        return dataSet!!.indexOf(item)
    }

    fun removeItem(position: Int) {
        dataSet!!.removeAt(position)
        notifyDataSetChanged()
    }
}