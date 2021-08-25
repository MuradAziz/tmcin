package com.example.tmcin.model

import com.google.firebase.database.Exclude

data class Products(
    var name:String?=null,
    var imageUrl:String?=null,
    @get:Exclude
    @set:Exclude
    var key:String?=null,
    var description:String?=null,
)
