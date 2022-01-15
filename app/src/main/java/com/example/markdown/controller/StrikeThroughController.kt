package com.example.markdown.controller

import android.widget.Toast
import com.example.markdown.Utils
import com.yydcdut.markdown.MarkdownEditText


class StrikeThroughController(private val mRxMDEditText: MarkdownEditText) {



    fun doStrikeThrough() {
        val start = mRxMDEditText.selectionStart
        val end = mRxMDEditText.selectionEnd
        if (start == end) {
            mRxMDEditText.text.insert(start, "~~~~")
            mRxMDEditText.setSelection(start + 2, end + 2)
        } else if (end - start > 4) { //选中了4个以上
            val position0: Int = Utils.findBeforeNewLineChar(mRxMDEditText.text, start) + 1
            val position00: Int = Utils.findBeforeNewLineChar(mRxMDEditText.text, end) + 1
            if (position0 != position00) {
                Toast.makeText(mRxMDEditText.context, "无法操作多行", Toast.LENGTH_SHORT).show()
                return
            }
            val editable = mRxMDEditText.text
            if ("~~" == editable.subSequence(
                    Utils.safePosition(start, editable),
                    Utils.safePosition(start + "~~".length, editable)
                ).toString() && "~~" == editable.subSequence(
                    Utils.safePosition(
                        end - "~~".length,
                        editable
                    ), Utils.safePosition(end, editable)
                ).toString()
            ) {
                mRxMDEditText.text.delete(end - "~~".length, end)
                mRxMDEditText.text.delete(start, start + "~~".length)
                mRxMDEditText.setSelection(start, end - "~~".length * 2)
            } else {
                mRxMDEditText.text.insert(end, "~~")
                mRxMDEditText.text.insert(start, "~~")
                mRxMDEditText.setSelection(start, end + "~~".length * 2)
            }
        } else {
            mRxMDEditText.text.insert(end, "~~")
            mRxMDEditText.text.insert(start, "~~")
            mRxMDEditText.setSelection(start, end + "~~".length * 2)
        }
    }
}
