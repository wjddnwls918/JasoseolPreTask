package com.example.myapplication.common

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import android.R
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerCrop
import android.R.attr.priority
import android.widget.TextView
import java.lang.String.format
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


object Binding {

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

        var format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        var to:Date = format.parse(date)

        var transDate = SimpleDateFormat("~MM월 dd일 HH시 mm분", Locale.getDefault()).format(to)

        view.text = transDate
    }

}