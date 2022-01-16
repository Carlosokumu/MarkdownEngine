package com.example.markdown.controller

import android.text.Editable
import android.widget.Toast
import com.example.markdown.Utils
import com.yydcdut.markdown.MarkdownEditText
import com.yydcdut.markdown.span.MDHorizontalRulesSpan


class HorizontalRulesController(private val mRxMDEditText: MarkdownEditText) {


    fun doHorizontalRules() {
        val start: Int = mRxMDEditText.selectionStart
        val end: Int = mRxMDEditText.selectionEnd
        val position0: Int = Utils.findBeforeNewLineChar(mRxMDEditText.text, start) + 1
        val position00: Int = Utils.findBeforeNewLineChar(mRxMDEditText.text, end) + 1
        if (position0 != position00) {
            Toast.makeText(mRxMDEditText.context, "无法操作多行", Toast.LENGTH_SHORT).show()
            return
        }
        val mdHorizontalRulesSpan: MDHorizontalRulesSpan? = Utils.getSpans(
            mRxMDEditText, start, end,
            MDHorizontalRulesSpan::class.java
        )
        if (mdHorizontalRulesSpan != null) {
            val editable: Editable = mRxMDEditText.getText()
            val spanStart = editable.getSpanStart(mdHorizontalRulesSpan)
            val spanEnd = editable.getSpanEnd(mdHorizontalRulesSpan)
            mRxMDEditText.text.removeSpan(mdHorizontalRulesSpan)
            mRxMDEditText.text.delete(spanStart, spanEnd)
        } else {
            val c0: Char = mRxMDEditText.text.charAt(if (start <= 0) 0 else start - 1)
            val c1: Char = mRxMDEditText.text.charAt(if (end >= mRxMDEditText.length() - 1) mRxMDEditText.length() - 1 else end + 1)
            val sb = StringBuilder()
            if (c0 != '\n' && start != 0) {
                sb.append("\n")
            }
            sb.append("---")
            if (c1 != '\n' || end >= mRxMDEditText.length()) {
                sb.append("\n")
            }
            mRxMDEditText.text.insert(start, sb.toString())
        }
    }
}
