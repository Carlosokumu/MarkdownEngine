package com.example.markdown.controller

import android.widget.Toast
import com.example.markdown.Utils
import com.yydcdut.markdown.MarkdownEditText


class TodoController(private val mRxMDEditText: MarkdownEditText) {


    fun doTodo() {
        val start = mRxMDEditText.selectionStart
        val end = mRxMDEditText.selectionEnd
        val position0: Int = Utils.findBeforeNewLineChar(mRxMDEditText.text, start) + 1
        val position00: Int = Utils.findBeforeNewLineChar(mRxMDEditText.text, end) + 1
        if (position0 != position00) {
            Toast.makeText(mRxMDEditText.context, "无法操作多行", Toast.LENGTH_SHORT).show()
            return
        }
        val editable = mRxMDEditText.text
        if ("- [ ] " == editable.subSequence(
                Utils.safePosition(position0, editable),
                Utils.safePosition(position0 + "- [ ] ".length, editable)
            ).toString()
        ) {
            editable.delete(position0, position0 + "- [ ] ".length)
        } else if ("- [x] ".equals(
                editable.subSequence(
                    Utils.safePosition(position0, editable),
                    Utils.safePosition(position0 + "- [ ] ".length, editable)
                ).toString(), ignoreCase = true
            )
        ) {
            editable.delete(position0, position0 + "- [x] ".length)
            editable.insert(position0, "- [ ] ")
        } else {
            editable.insert(position0, "- [ ] ")
        }
    }

    fun doTodoDone() {
        val start = mRxMDEditText.selectionStart
        val end = mRxMDEditText.selectionEnd
        val position0: Int = Utils.findBeforeNewLineChar(mRxMDEditText.text, start) + 1
        val position00: Int = Utils.findBeforeNewLineChar(mRxMDEditText.text, end) + 1
        if (position0 != position00) {
            Toast.makeText(mRxMDEditText.context, "无法操作多行", Toast.LENGTH_SHORT).show()
            return
        }
        val editable = mRxMDEditText.text
        if ("- [x] " == editable.subSequence(
                Utils.safePosition(position0, editable),
                Utils.safePosition(position0 + "- [x] ".length, editable)
            ).toString()
        ) {
            mRxMDEditText.text.delete(position0, position0 + "- [x] ".length)
        } else if ("- [ ] ".equals(
                editable.subSequence(
                    Utils.safePosition(position0, editable),
                    Utils.safePosition(position0 + "- [ ] ".length, editable)
                ).toString(), ignoreCase = true
            )
        ) {
            editable.delete(position0, position0 + "- [ ] ".length)
            editable.insert(position0, "- [x] ")
        } else {
            editable.insert(position0, "- [x] ")
        }
    }

}
