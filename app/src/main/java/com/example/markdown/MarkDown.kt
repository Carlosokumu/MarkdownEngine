package com.example.markdown

import android.app.Application

class MarkDown: Application() {





    override fun onCreate() {
        super.onCreate()
        MarKBox.init(this)
    }
}