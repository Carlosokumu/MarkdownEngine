package com.example.markdown

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import us.feras.mdv.MarkdownView




class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val markdownView = MarkdownView(this)
        setContentView(markdownView)
        markdownView.loadMarkdown("## Hello Markdown")
    }
}