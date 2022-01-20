package com.example.markdown.controller

import android.text.Editable
import android.widget.Toast
import com.example.markdown.helpers.Utils
import com.yydcdut.markdown.MarkdownEditText


class BlockQuotesController(private val mRxMDEditText: MarkdownEditText) {


    fun doBlockQuotes() {
        val start: Int = mRxMDEditText.getSelectionStart()
        val end: Int = mRxMDEditText.getSelectionEnd()
        if (start == end) {
            val position0: Int = Utils.findBeforeNewLineChar(mRxMDEditText.getText(), start) + 1
            val editable: Editable = mRxMDEditText.getText()
            if ("> " == editable.subSequence(
                    Utils.safePosition(position0, editable),
                    Utils.safePosition(position0 + "> ".length, editable)
                ).toString()
            ) {
                mRxMDEditText.getText().delete(position0, position0 + "> ".length)
                return
            }
            mRxMDEditText.getText().insert(position0, "> ")
        } else {
            val position0: Int = Utils.findBeforeNewLineChar(mRxMDEditText.getText(), start) + 1
            val position1: Int = Utils.findBeforeNewLineChar(mRxMDEditText.getText(), end) + 1
            if (position0 == position1) {
                val editable: Editable = mRxMDEditText.getText()
                val selectedStart: Int = mRxMDEditText.getSelectionStart()
                val selectedEnd: Int = mRxMDEditText.getSelectionEnd()
                if (selectedStart >= "> ".length && "> " == editable.subSequence(
                        Utils.safePosition(
                            selectedStart - "> ".length,
                            editable
                        ), Utils.safePosition(selectedStart, editable)
                    ).toString() &&
                    (selectedStart > "\n> ".length && editable[selectedStart - 3] == '\n' || selectedStart < "\n> ".length) || selectedStart > "> > ".length && "> > " == editable.subSequence(
                        Utils.safePosition(selectedStart - "> > ".length, editable),
                        Utils.safePosition(selectedStart, editable)
                    ).toString()
                ) {
                    mRxMDEditText.getText().delete(selectedStart - "> ".length, selectedStart)
                    mRxMDEditText.setSelection(
                        selectedStart - "> ".length,
                        selectedEnd - "> ".length
                    )
                    return
                }
                if (selectedStart > 0 && editable[selectedStart - 1] == '\n' || selectedStart == 0) {
                    if (selectedEnd < editable.length && editable[selectedEnd] != '\n') {
                        mRxMDEditText.getText().insert(selectedEnd, "\n")
                    }
                    mRxMDEditText.getText().insert(selectedStart, "> ")
                    mRxMDEditText.setSelection(
                        selectedStart + "> ".length,
                        selectedEnd + "> ".length
                    )
                } else {
                    if (selectedEnd + 1 < editable.length && editable[selectedEnd + 1] != '\n') {
                        mRxMDEditText.getText().insert(selectedEnd, "\n")
                    }
                    mRxMDEditText.getText().insert(selectedStart, "\n> ")
                    mRxMDEditText.setSelection(
                        selectedStart + "\n> ".length,
                        selectedEnd + "\n> ".length
                    )
                }
            } else {
                Toast.makeText(mRxMDEditText.getContext(), "无法操作多行", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun addNestedBlockQuotes() {
        val start: Int = mRxMDEditText.getSelectionStart()
        val end: Int = mRxMDEditText.getSelectionEnd()
        if (start == end) {
            val position0: Int = Utils.findBeforeNewLineChar(mRxMDEditText.getText(), start) + 1
            mRxMDEditText.getText().insert(position0, "> ")
        } else {
            val position0: Int = Utils.findBeforeNewLineChar(mRxMDEditText.getText(), start) + 1
            val position1: Int = Utils.findBeforeNewLineChar(mRxMDEditText.getText(), end) + 1
            if (position0 == position1) {
                val selectedStart: Int = mRxMDEditText.getSelectionStart()
                val selectedEnd: Int = mRxMDEditText.getSelectionEnd()
                val editable: Editable = mRxMDEditText.getText()
                if (selectedStart >= "> ".length && "> " == editable.subSequence(
                        Utils.safePosition(
                            selectedStart - "> ".length,
                            editable
                        ), Utils.safePosition(selectedStart, editable)
                    ).toString() &&
                    (selectedStart > "\n> ".length && editable[selectedStart - 3] == '\n' || selectedStart < "\n> ".length) || selectedStart > "> > ".length && "> > " == editable.subSequence(
                        Utils.safePosition(selectedStart - "> > ".length, editable),
                        Utils.safePosition(selectedStart, editable)
                    ).toString()
                ) {
                    mRxMDEditText.getText().insert(selectedStart, "> ")
                    mRxMDEditText.setSelection(
                        selectedStart + "> ".length,
                        selectedEnd + "> ".length
                    )
                    return
                }
                if (selectedStart > 0 && editable[selectedStart - 1] == '\n' || selectedStart == 0) {
                    if (selectedEnd < editable.length && editable[selectedEnd] != '\n') {
                        mRxMDEditText.getText().insert(selectedEnd, "\n")
                    }
                    mRxMDEditText.getText().insert(selectedStart, "> ")
                    mRxMDEditText.setSelection(
                        selectedStart + "> ".length,
                        selectedEnd + "> ".length
                    )
                } else {
                    if (selectedEnd + 1 < editable.length && editable[selectedEnd + 1] != '\n') {
                        mRxMDEditText.getText().insert(selectedEnd, "\n")
                    }
                    mRxMDEditText.getText().insert(selectedStart, "\n> ")
                    mRxMDEditText.setSelection(
                        selectedStart + "\n> ".length,
                        selectedEnd + "\n> ".length
                    )
                }
            } else {
                Toast.makeText(mRxMDEditText.getContext(), "无法操作多行", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
