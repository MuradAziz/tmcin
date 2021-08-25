package com.example.tmcin.uitel

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tmcin.R


fun ImageView.loadImage(url:String?){
    val option=RequestOptions().placeholder(R.drawable.tmc)
        .error(R.drawable.tmc)
    Glide.with(context)
        .setDefaultRequestOptions(option)
        .load(url)
        .into(this)




}