package com.example.markdown.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ScrollView




class EditScrollView(context: Context, attrs: AttributeSet, defStyleAttr: Int): ScrollView(context, attrs,defStyleAttr) {
    lateinit var listener: onScrollChangedListener


    fun setOnScrollChangedListener(listener: onScrollChangedListener){
        this.listener =listener
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        listener.ScrollChanged(l,t,oldl,oldt)
    }




    interface onScrollChangedListener{
        fun ScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int)
    }

}