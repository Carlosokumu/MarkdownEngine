package com.example.markdown

import android.app.Application
import com.example.markdown.smalldb.MarKBox

class MarkDown: Application() {





    override fun onCreate() {
        super.onCreate()
        MarKBox.init(this)
    }
}