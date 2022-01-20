package com.example.markdown.controller

import android.widget.Toast
import com.example.markdown.helpers.Utils
import com.yydcdut.markdown.MarkdownEditText
import com.yydcdut.markdown.span.MDOrderListSpan
import com.yydcdut.markdown.span.MDUnOrderListSpan


class ListController(private val mRxMDEditText: MarkdownEditText) {
    fun doUnOrderList() {
        val start: Int = mRxMDEditText.getSelectionStart()
        val end: Int = mRxMDEditText.getSelectionEnd()
        if (start == end) {
            val mdUnOrderListSpan = Utils.getSpans(
                mRxMDEditText, start, end,
                MDUnOrderListSpan::class.java
            )
            val position: Int = Utils.findBeforeNewLineChar(mRxMDEditText.getText(), start) + 1
            if (mdUnOrderListSpan != null) {
                if (mdUnOrderListSpan.nested == 0) {
                    mRxMDEditText.getText().delete(position, position + "* ".length)
                    //                    mRxMDEditText.getText().removeSpan(mdUnOrderListSpan);
                    return
                }
                mRxMDEditText.getText().delete(position, position + 1)
                //                mRxMDEditText.getText().removeSpan(mdUnOrderListSpan);
                return
            }
            mRxMDEditText.getText().insert(position, "* ")
        } else {
            val position0: Int = Utils.findBeforeNewLineChar(mRxMDEditText.getText(), start) + 1
            val position00: Int = Utils.findBeforeNewLineChar(mRxMDEditText.getText(), end) + 1
            if (position0 != position00) {
                Toast.makeText(mRxMDEditText.getContext(), "无法操作多行", Toast.LENGTH_SHORT).show()
                return
            }
            //            int selectedStart = mRxMDEditText.getSelectionStart();
//            int selectedEnd = mRxMDEditText.getSelectionEnd();
            val mdUnOrderListSpan = Utils.getSpans(
                mRxMDEditText, start, end,
                MDUnOrderListSpan::class.java
            )
            if (mdUnOrderListSpan != null) {
                if (mdUnOrderListSpan.nested == 0) {
                    mRxMDEditText.getText().delete(position0, position0 + "* ".length)
                    //                    mRxMDEditText.setSelection(selectedStart - "* ".length(), selectedEnd - "* ".length());
                    return
                }
                mRxMDEditText.getText().delete(position0, position0 + 1)
                //                mRxMDEditText.setSelection(selectedStart - 1, selectedEnd - 1);
                return
            }
            mRxMDEditText.getText().insert(position0, "* ")
            //            mRxMDEditText.setSelection(selectedStart + "* ".length(), selectedEnd + "* ".length());
        }
    }

    fun doOrderList() {
        val start: Int = mRxMDEditText.getSelectionStart()
        val end: Int = mRxMDEditText.getSelectionEnd()
        if (start == end) {
            val mdOrderListSpan = Utils.getSpans(
                mRxMDEditText, start, end,
                MDOrderListSpan::class.java
            )
            val position: Int = Utils.findBeforeNewLineChar(mRxMDEditText.getText(), start) + 1
            if (mdOrderListSpan != null) {
                mRxMDEditText.getText().delete(
                    position,
                    position + mdOrderListSpan.nested + (mdOrderListSpan.number / 10 + 1) + ". ".length
                )
                return
            }
            if (position == 0) {
                mRxMDEditText.getText().insert(position, "1. ")
            } else {
                val mdBeforeLineOrderListSpan = Utils.getSpans(
                    mRxMDEditText, position - 1, position - 1,
                    MDOrderListSpan::class.java
                )
                if (mdBeforeLineOrderListSpan != null) {
                    val sb = StringBuilder()
                    for (i in 0 until mdBeforeLineOrderListSpan.nested) {
                        sb.append(" ")
                    }
                    sb.append(mdBeforeLineOrderListSpan.number + 1).append(". ")
                    mRxMDEditText.getText().insert(position, sb.toString())
                } else {
                    mRxMDEditText.getText().insert(position, "1. ")
                }
            }
        } else {
            val position0: Int = Utils.findBeforeNewLineChar(mRxMDEditText.getText(), start) + 1
            val position00: Int = Utils.findBeforeNewLineChar(mRxMDEditText.getText(), end) + 1
            if (position0 != position00) {
                Toast.makeText(mRxMDEditText.getContext(), "无法操作多行", Toast.LENGTH_SHORT).show()
                return
            }
            //            int selectedStart = mRxMDEditText.getSelectionStart();
//            int selectedEnd = mRxMDEditText.getSelectionEnd();
            val mdOrderListSpan = Utils.getSpans(
                mRxMDEditText, start, end,
                MDOrderListSpan::class.java
            )
            if (mdOrderListSpan != null) {
                if (mdOrderListSpan.nested == 0) {
                    val deleteLength =
                        position0 + mdOrderListSpan.nested + (mdOrderListSpan.number / 10 + 1) + ". ".length
                    mRxMDEditText.getText().delete(position0, deleteLength)
                    //                    mRxMDEditText.setSelection(selectedStart - deleteLength, selectedEnd - deleteLength);
                    return
                }
                mRxMDEditText.getText().delete(position0, position0 + 1)
                //                mRxMDEditText.setSelection(selectedStart - 1, selectedEnd - 1);
                return
            }
            if (position0 == 0) {
                mRxMDEditText.getText().insert(position0, "1. ")
            } else {
                val mdBeforeLineOrderListSpan = Utils.getSpans(
                    mRxMDEditText, position0 - 1, position0 - 1,
                    MDOrderListSpan::class.java
                )
                if (mdBeforeLineOrderListSpan != null) {
                    val sb = StringBuilder()
                    for (i in 0 until mdBeforeLineOrderListSpan.nested) {
                        sb.append(" ")
                    }
                    sb.append(mdBeforeLineOrderListSpan.number + 1).append(". ")
                    mRxMDEditText.getText().insert(position0, sb.toString())
                    //                    mRxMDEditText.setSelection(selectedStart + sb.length(), selectedEnd + sb.length());
                } else {
                    mRxMDEditText.getText().insert(position0, "1. ")
                    //                    mRxMDEditText.setSelection(selectedStart + "1. ".length(), selectedEnd + "1. ".length());
                }
            }
        }
    }
}
