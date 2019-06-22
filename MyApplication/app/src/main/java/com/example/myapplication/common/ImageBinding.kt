package com.example.myapplication.common

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import android.R
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerCrop
import android.R.attr.priority


object ImageBinding {

    @JvmStatic
    @BindingAdapter("inputImage")
    fun inputImage(view: ImageView, image: String) {
        Log.d("checkdata", image)

        Glide.with(view.context)
            .load(image)
            .into(view)
    }
}