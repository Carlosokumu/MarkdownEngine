package com.example.markdown.controller

import android.text.Editable
import android.widget.Toast
import com.example.markdown.Utils
import com.yydcdut.markdown.MarkdownEditText
import com.yydcdut.markdown.span.MDHorizontalRulesSpan


class HorizontalRulesController(private val mRxMDEditText: MarkdownEditText) {


    fun doHorizontalRules() {
        val start: Int = mRxMDEditText.getSelectionStart()
        val end: Int = mRxMDEditText.getSelectionEnd()
        val position0: Int = Utils.findBeforeNewLineChar(mRxMDEditText.getText(), start) + 1
        val position00: Int = Utils.findBeforeNewLineChar(mRxMDEditText.getText(), end) + 1
        if (position0 != position00) {
            Toast.makeText(mRxMDEditText.getContext(), "无法操作多行", Toast.LENGTH_SHORT).show()
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
            mRxMDEditText.getText().removeSpan(mdHorizontalRulesSpan)
            mRxMDEditText.getText().delete(spanStart, spanEnd)
        } else {
            val c0: Char = mRxMDEditText.getText().charAt(if (start <= 0) 0 else start - 1)
            val c1: Char = mRxMDEditText.getText().charAt(if (end >= mRxMDEditText.length() - 1) mRxMDEditText.length() - 1 else end + 1)
            val sb = StringBuilder()
            if (c0 != '\n' && start != 0) {
                sb.append("\n")
            }
            sb.append("---")
            if (c1 != '\n' || end >= mRxMDEditText.length()) {
                sb.append("\n")
            }
            mRxMDEditText.getText().insert(start, sb.toString())
        }
    }
}
