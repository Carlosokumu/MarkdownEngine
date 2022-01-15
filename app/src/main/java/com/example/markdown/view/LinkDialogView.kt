package com.example.markdown.view

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout


class LinkDialogView : LinearLayout() {


    private var mDescriptionEditText: EditText? = null
    private var mLinkEditText: EditText? = null


    private fun init(context: Context) {
        val v: View = LayoutInflater.from(context).inflate(R.layout.dialog_link, this, true)
        mDescriptionEditText = v.findViewById(R.id.edit_description_link) as EditText
        mLinkEditText = v.findViewById(R.id.edit_link) as EditText
    }

    fun clear() {
        mDescriptionEditText.setText("")
        mLinkEditText.setText("http://")
    }

    fun getDescription(): String? {
        return mDescriptionEditText.getText().toString()
    }

    fun getLink(): String? {
        return mLinkEditText.getText().toString()
    }
}
