package com.example.markdown.smalldb

import android.content.Context
import com.example.markdown.MarkDowns
import com.example.markdown.MyObjectBox
import io.objectbox.BoxStore

object MarKBox {


    lateinit var store: BoxStore
        private set


    fun init(context: Context){
        store =  MyObjectBox.builder().androidContext(context.applicationContext).build()
    }


    /*

          Acts as a central  repository to give us markdown content
     */

    fun getContents(): List<MarkDowns> = store.boxFor(MarkDowns::class.java).all

}