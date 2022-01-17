package com.example.markdown.controller

import android.content.Intent
import android.text.TextUtils
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import com.example.markdown.view.ImageDialogView
import com.yydcdut.markdown.MarkdownEditText


class ImageController(private val mRxMDEditText: MarkdownEditText? = null) {



    private var mImageDialogView: ImageDialogView? = null
    private var mAlertDialog: AlertDialog? = null



   init {
       if (mRxMDEditText != null) {
           mImageDialogView = ImageDialogView(mRxMDEditText.context)
       }
       mImageDialogView!!.layoutParams = LinearLayout.LayoutParams(
           ViewGroup.LayoutParams.MATCH_PARENT,
           ViewGroup.LayoutParams.WRAP_CONTENT
       )
   }

    fun doImage() {
        if (mAlertDialog == null) {
            initDialog()
        }
        mImageDialogView!!.clear()
        mAlertDialog!!.show()
    }



    private fun initDialog() {
        mAlertDialog = AlertDialog.Builder(mRxMDEditText!!.context)
            .setView(mImageDialogView)
            .setPositiveButton("Ok") { dialog, _ ->
                dialog.dismiss()
                val width = mImageDialogView!!.getImageWidth()
                val height = mImageDialogView!!.getImageHeight()
                val path = mImageDialogView!!.getPath()
                val description = mImageDialogView!!.getDescription()
                doRealImage(width, height, path!!, description!!)
            }
            .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
            .setCancelable(false)
            .create()
    }


    fun handleResult(requestCode: Int, resultCode: Int, data: Intent?) {
        mImageDialogView!!.handleResult(requestCode, resultCode, data)
    }



    private fun doRealImage(width: Int, height: Int, path: String, description: String) {
        val start = mRxMDEditText!!.selectionStart
        if (TextUtils.isEmpty(description)) {
            mRxMDEditText.text.insert(start, "![]($path/$width$$height)")
            mRxMDEditText.setSelection(start + 2)
        } else {
            mRxMDEditText.text.insert(start, "![$description]($path/$width$$height)")
        }
    }

}
