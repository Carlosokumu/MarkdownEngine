package com.example.markdown

import android.content.Context
import io.objectbox.BoxStore

object MarKBox {


    lateinit var store: BoxStore
        private set


    fun init(context: Context){
        store =  MyObjectBox.builder().androidContext(context.applicationContext).build()
    }

}