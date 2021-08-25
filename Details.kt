package com.example.tmcin.view




import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tmcin.R
import com.example.tmcin.uitel.loadImage

import kotlinx.android.synthetic.main.activity_details.*

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val intss=intent
        var nameT=intss.getStringExtra("NAMET")
        var dest=intss.getStringExtra("DESCRIT")
        var imgT=intss.getStringExtra("IMGURI")

        namedetails.text=nameT
        descriptiondetails.text=dest
        Productdetailsimage.loadImage(imgT)
    }
}