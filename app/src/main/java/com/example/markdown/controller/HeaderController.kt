package com.example.markdown.controller

import android.text.style.RelativeSizeSpan
import android.widget.Toast
import com.example.markdown.Utils
import com.yydcdut.markdown.MarkdownConfiguration
import com.yydcdut.markdown.MarkdownEditText


class HeaderController(private val mRxMDEditText: MarkdownEditText,private val mRxMDConfiguration: MarkdownConfiguration) {

    fun doHeader(headerNumber: Int) {
        val start: Int = mRxMDEditText.selectionStart
        val end: Int = mRxMDEditText.selectionEnd
        var position0: Int = Utils.findBeforeNewLineChar(mRxMDEditText.text, start) + 1
        val position1: Int = Utils.findBeforeNewLineChar(mRxMDEditText.text, end) + 1
        if (position0 == position1) {
            val hasCenterSpan: Boolean = Utils.hasCenterSpan(mRxMDEditText, start, end)
            if (hasCenterSpan) {
                position0 += 1
            }
            val relativeSizeSpan: RelativeSizeSpan? = Utils.getSpans(
                mRxMDEditText, start, end,
                RelativeSizeSpan::class.java
            )
            if (relativeSizeSpan == null) {
                addHeaderKey(position0, headerNumber)
                return
            }
            replace(position0, headerNumber, headerNumber, relativeSizeSpan)
        } else {
            Toast.makeText(mRxMDEditText.context, "无法操作多行", Toast.LENGTH_SHORT).show()
        }
    }
    private fun replace(
        startPosition: Int,
        deleteHeaderNumber: Int,
        addHeaderNumber: Int,
        relativeSizeSpan: RelativeSizeSpan
    ) {
        if (relativeSizeSpan.sizeChange == mRxMDConfiguration.header1RelativeSize) {
            deleteHeaderKey(startPosition, 1)
            mRxMDEditText.text.removeSpan(relativeSizeSpan)
            if (deleteHeaderNumber != 1) {
                addHeaderKey(startPosition, addHeaderNumber)
            }
        } else if (relativeSizeSpan.sizeChange == mRxMDConfiguration.header2RelativeSize) {
            deleteHeaderKey(startPosition, 2)
            mRxMDEditText.text.removeSpan(relativeSizeSpan)
            if (deleteHeaderNumber != 2) {
                addHeaderKey(startPosition, addHeaderNumber)
            }
        } else if (relativeSizeSpan.sizeChange == mRxMDConfiguration.header3RelativeSize) {
            deleteHeaderKey(startPosition, 3)
            mRxMDEditText.text.removeSpan(relativeSizeSpan)
            if (deleteHeaderNumber != 3) {
                addHeaderKey(startPosition, addHeaderNumber)
            }
        } else if (relativeSizeSpan.sizeChange == mRxMDConfiguration.header4RelativeSize) {
            deleteHeaderKey(startPosition, 4)
            mRxMDEditText.text.removeSpan(relativeSizeSpan)
            if (deleteHeaderNumber != 4) {
                addHeaderKey(startPosition, addHeaderNumber)
            }
        } else if (relativeSizeSpan.sizeChange == mRxMDConfiguration.header5RelativeSize) {
            deleteHeaderKey(startPosition, 5)
            mRxMDEditText.text.removeSpan(relativeSizeSpan)
            if (deleteHeaderNumber != 5) {
                addHeaderKey(startPosition, addHeaderNumber)
            }
        } else if (relativeSizeSpan.sizeChange == mRxMDConfiguration.getHeader6RelativeSize()) {
            deleteHeaderKey(startPosition, 6)
            mRxMDEditText.text.removeSpan(relativeSizeSpan)
            if (deleteHeaderNumber != 6) {
                addHeaderKey(startPosition, addHeaderNumber)
            }
        }
    }

    private fun deleteHeaderKey(startPosition: Int, deleteHeader: Int) {
        when (deleteHeader) {
            1 -> mRxMDEditText.text.delete(startPosition, startPosition + "# ".length)
            2 -> mRxMDEditText.text.delete(startPosition, startPosition + "## ".length)
            3 -> mRxMDEditText.text.delete(startPosition, startPosition + "### ".length)
            4 -> mRxMDEditText.text.delete(startPosition, startPosition + "#### ".length)
            5 -> mRxMDEditText.text.delete(startPosition, startPosition + "##### ".length)
            6 -> mRxMDEditText.text.delete(startPosition, startPosition + "###### ".length)
        }
    }

    private fun addHeaderKey(startPosition: Int, addHeader: Int) {
        when (addHeader) {
            1 -> mRxMDEditText.text.insert(startPosition, "# ")
            2 -> mRxMDEditText.text.insert(startPosition, "## ")
            3 -> mRxMDEditText.text.insert(startPosition, "### ")
            4 -> mRxMDEditText.text.insert(startPosition, "#### ")
            5 -> mRxMDEditText.text.insert(startPosition, "##### ")
            6 -> mRxMDEditText.text.insert(startPosition, "###### ")
        }
    }

}
