package com.example.markdown.controller

import android.text.TextUtils
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import com.example.markdown.view.LinkDialogView
import com.yydcdut.markdown.MarkdownEditText


class LinkController(rxMDEditText: MarkdownEditText) {



    private var mLinkDialogView: LinkDialogView? = null
    private val mRxMDEditText: MarkdownEditText? = null

    private var mAlertDialog: AlertDialog? = null

   init {
       mLinkDialogView = LinkDialogView(rxMDEditText.context)
       mLinkDialogView!!.layoutParams = LinearLayout.LayoutParams(
           ViewGroup.LayoutParams.MATCH_PARENT,
           ViewGroup.LayoutParams.WRAP_CONTENT
       )
   }
    fun doImage() {
        if (mAlertDialog == null) {
            initDialog()
        }
        mLinkDialogView!!.clear()
        mAlertDialog!!.show()
    }


    private fun initDialog() {
        mAlertDialog = AlertDialog.Builder(mRxMDEditText!!.context)
            .setView(mLinkDialogView)
            .setPositiveButton("确定") { dialog, which ->
                dialog.dismiss()
                val description = mLinkDialogView!!.getDescription()
                val link = mLinkDialogView!!.getLink()
                doRealLink(description!!, link!!)
            }
            .setNegativeButton(
                "取消"
            ) { dialog, which -> dialog.dismiss() }
            .setTitle("Link")
            .setCancelable(false)
            .create()
    }


    private fun doRealLink(description: String, link: String) {
        val start = mRxMDEditText!!.selectionStart
        if (TextUtils.isEmpty(description)) {
            mRxMDEditText.text.insert(start, "[]($link)")
            mRxMDEditText.setSelection(start + 2)
        } else {
            mRxMDEditText.text.insert(start, "[$description]($link)")
        }
    }
}
