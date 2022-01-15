package com.example.markdown.controller

import android.widget.Toast
import com.example.markdown.Utils
import com.yydcdut.markdown.MarkdownEditText


class CodeController(private val mRxMDEditText: MarkdownEditText) {


    fun doInlineCode() {
        val start = mRxMDEditText.selectionStart
        val end = mRxMDEditText.selectionEnd
        if (start == end) {
            mRxMDEditText.text.insert(start, "``")
            mRxMDEditText.setSelection(start + 1, end + 1)
        } else if (end - start > 2) { //选中了4个以上
            val position0: Int = Utils.findBeforeNewLineChar(mRxMDEditText.text, start) + 1
            val position00: Int = Utils.findBeforeNewLineChar(mRxMDEditText.text, end) + 1
            if (position0 != position00) {
                Toast.makeText(mRxMDEditText.context, "无法操作多行", Toast.LENGTH_SHORT).show()
                return
            }
            val editable = mRxMDEditText.text
            if ("`" == editable.subSequence(
                    Utils.safePosition(start, editable),
                    Utils.safePosition(start + "`".length, editable)
                ).toString() && "`" == editable.subSequence(
                    Utils.safePosition(
                        end - "`".length,
                        editable
                    ), Utils.safePosition(end, editable)
                ).toString()
            ) {
                mRxMDEditText.text.delete(end - "`".length, end)
                mRxMDEditText.text.delete(start, start + "`".length)
                mRxMDEditText.setSelection(start, end - "`".length * 2)
            } else {
                mRxMDEditText.text.insert(end, "`")
                mRxMDEditText.text.insert(start, "`")
                mRxMDEditText.setSelection(start, end + "`".length * 2)
            }
        } else {
            mRxMDEditText.text.insert(end, "`")
            mRxMDEditText.text.insert(start, "`")
            mRxMDEditText.setSelection(start, end + "`".length * 2)
        }
    }

    fun doCode() {
        val start = mRxMDEditText.selectionStart
        val end = mRxMDEditText.selectionEnd
        if (start == end) {
            val position0: Int = Utils.findBeforeNewLineChar(mRxMDEditText.text, start) + 1
            var position1: Int = Utils.findNextNewLineChar(mRxMDEditText.text, end)
            if (position1 == -1) {
                position1 = mRxMDEditText.length()
            }
            val editable = mRxMDEditText.text
            if (position0 >= 4 && position1 < mRxMDEditText.length() - 4) {
                val begin = "```" == editable.subSequence(
                    Utils.safePosition(
                        position0 - 1 - "```".length,
                        editable
                    ), Utils.safePosition(position0 - 1, editable)
                ).toString()
                if (begin && "```\n" == editable.subSequence(
                        Utils.safePosition(
                            position1 + 1,
                            editable
                        ), Utils.safePosition(position1 + 1 + "```\n".length, editable)
                    ).toString()
                ) {
                    mRxMDEditText.text.delete(position1 + 1, position1 + 1 + "```\n".length)
                    mRxMDEditText.text.delete(position0 - "\n```".length, position0)
                    return
                }
            }
            val selectedStart = mRxMDEditText.selectionStart
            val c =
                mRxMDEditText.text[if (position1 >= mRxMDEditText.length()) mRxMDEditText.length() - 1 else position1]
            if (c == '\n') {
                mRxMDEditText.text.insert(position1, "\n```")
            } else {
                mRxMDEditText.text.insert(position1, "\n```\n")
            }
            mRxMDEditText.text.insert(position0, "```\n")
            mRxMDEditText.setSelection(
                selectedStart + "```\n".length,
                selectedStart + "```\n".length
            )
        } else if (end - start > 6) {
            val editable = mRxMDEditText.text
            if ("```" == editable.subSequence(
                    Utils.safePosition(start, editable),
                    Utils.safePosition(start + "```".length, editable)
                ).toString() && "```" == editable.subSequence(
                    Utils.safePosition(
                        end - "```".length,
                        editable
                    ), Utils.safePosition(end, editable)
                ).toString()
            ) {
                val selectedStart = mRxMDEditText.selectionStart
                val selectedEnd = mRxMDEditText.selectionEnd
                mRxMDEditText.text.delete(end - "\n```".length, end)
                mRxMDEditText.text.delete(start, start + "```\n".length)
                mRxMDEditText.setSelection(selectedStart, selectedEnd - 8)
                return
            }
            code(start, end)
        } else {
            code(start, end)
        }
    }

    private fun code(start: Int, end: Int) {
        var selectedStart = mRxMDEditText.selectionStart
        val selectedEnd = mRxMDEditText.selectionEnd
        var endAdd = 0
        val c =
            mRxMDEditText.text[if (end >= mRxMDEditText.length()) mRxMDEditText.length() - 1 else end]
        if (c == '\n') {
            mRxMDEditText.text.insert(end, "\n```")
            endAdd += 4
        } else {
            mRxMDEditText.text.insert(end, "\n```\n")
            endAdd += 5
            selectedStart = selectedStart + 1
        }
        val c1 = mRxMDEditText.text[if (start - 1 < 0) 0 else start - 1]
        endAdd += if (c1 == '\n' || start - 1 < 0) {
            mRxMDEditText.text.insert(start, "```\n")
            4
        } else {
            mRxMDEditText.text.insert(start, "\n```\n")
            4
        }
        mRxMDEditText.setSelection(selectedStart, selectedEnd + endAdd)
    }
}
