package com.example.myapplication.view.enterpriselist

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*


object EnterpriseListBinding {

    @JvmStatic
    @BindingAdapter("inputImage")
    fun inputImage(view: ImageView, image: String) {
        Glide.with(view.context)
            .load(image)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("inputTransDate")
    fun inputTransDate(view: TextView, date: String) {
        view.text = transDate(date)
    }

    private fun transDate(date: String): String {

        var curFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        var to: Date = curFormat.parse(date)

        return SimpleDateFormat("~MM월 dd일 HH시 mm분", Locale.getDefault()).format(to)
    }

}