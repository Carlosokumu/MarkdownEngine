package com.example.markdown.controller

import android.widget.Toast
import com.example.markdown.helpers.Utils
import com.yydcdut.markdown.MarkdownEditText


class CenterAlignController(private val mRxMDEditText: MarkdownEditText) {



    fun doCenter() {
        val start = mRxMDEditText!!.selectionStart
        val end = mRxMDEditText!!.selectionEnd
        val position0: Int = Utils.findBeforeNewLineChar(mRxMDEditText!!.text, start) + 1
        val position1: Int = Utils.findBeforeNewLineChar(mRxMDEditText!!.text, end) + 1
        if (position0 == position1) {
            var position2: Int = Utils.findNextNewLineChar(mRxMDEditText!!.text, end)
            if (position2 == -1) {
                position2 = mRxMDEditText!!.length()
            }
            val editable = mRxMDEditText!!.text
            if ("[" == editable.subSequence(
                    Utils.safePosition(position0, editable),
                    Utils.safePosition(position0 + 1, editable)
                ).toString() && "]" == editable.subSequence(
                    Utils.safePosition(
                        position2 - 1,
                        editable
                    ), Utils.safePosition(position2, editable)
                ).toString()
            ) {
                mRxMDEditText!!.text.delete(position2 - 1, position2)
                mRxMDEditText!!.text.delete(position0, position0 + 1)
            } else {
                mRxMDEditText!!.text.insert(position2, "]")
                mRxMDEditText!!.text.insert(position0, "[")
            }
        } else {
            Toast.makeText(mRxMDEditText!!.context, "无法操作多行", Toast.LENGTH_SHORT).show()
        }
    }

}
