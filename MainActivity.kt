package com.example.tmcin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tmcin.view.Items
import com.example.tmcin.view.UploadActivity
import kotlinx.android.synthetic.main.activity_main.*


    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            btnview.setOnClickListener {
                startActivity(Intent(this, Items::class.java))
            }
            btnadd.setOnClickListener {
                startActivity(Intent(this, UploadActivity::class.java))
            }
        }
    }
