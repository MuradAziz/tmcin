package com.example.tmcin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmcin.R
import com.example.tmcin.model.Products
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_items.*


class Items : AppCompatActivity() {
    private var mStorage:FirebaseStorage?=null
    private var mDatabaseRef:DatabaseReference?=null
    private var mDBlistener:ValueEventListener?=null
    private lateinit var mProducts: MutableList<Products>
    private lateinit var listAdapter:com.example.tmcin.adapter.ListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        mRecycleview.setHasFixedSize(true)
        mRecycleview.layoutManager=LinearLayoutManager(this@Items)
        mydatdaloader.visibility= View.VISIBLE
        mProducts=ArrayList()
        listAdapter=com.example.tmcin.adapter.ListAdapter(this@Items, mProducts)
        mRecycleview.adapter=listAdapter
        mStorage= FirebaseStorage.getInstance()
        mDatabaseRef=FirebaseDatabase.getInstance().getReference("Products_upload")
        mDBlistener=mDatabaseRef!!.addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Items, error.message, Toast.LENGTH_SHORT).show()
                mydatdaloader.visibility=View.INVISIBLE

            }

            override fun onDataChange(snapshot: DataSnapshot) {
            mProducts.clear()
                for(productSnapshot in snapshot.children){
                    val upload=productSnapshot.getValue(Products::class.java)
                    upload!!.key=productSnapshot.key
                    mProducts.add(upload)
                }
                listAdapter.notifyDataSetChanged()
                mydatdaloader.visibility=View.GONE
            }

        })
        fun onDestroy() {
            super.onDestroy()
            mDatabaseRef!!.removeEventListener(mDBlistener!! )
        }
    }
}