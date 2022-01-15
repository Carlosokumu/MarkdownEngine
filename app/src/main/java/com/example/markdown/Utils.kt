package com.example.markdown

import android.R.attr
import android.text.style.AlignmentSpan
import android.widget.EditText
import com.yydcdut.markdown.span.MDOrderListSpan
import com.yydcdut.markdown.span.MDUnOrderListSpan
import com.yydcdut.markdown.utils.TextHelper
import com.yydcdut.rxmarkdown.RxMDEditText


object Utils {





    fun findNextNewLineChar(s: CharSequence, start: Int): Int {
        for (i in start until s.length) {
            if (s[i] == '\n') {
                return i
            }
        }
        return -1
    }


    fun findBeforeNewLineChar(s: CharSequence, start: Int): Int {
        for (i in start - 1 downTo 1) {
            if (s[i] == '\n') {
                return i
            }
        }
        return -1
    }



    fun <T> getSpans(editText: EditText, start: Int, end: Int, clazz: Class<T>): T? {
        val ts = editText.text.getSpans(start, end, clazz)
        return if (ts != null && ts.isNotEmpty()) {
            ts[0]
        } else null
    }
    fun hasCenterSpan(editText: EditText, start: Int, end: Int): Boolean {
       val centerSpan: AlignmentSpan.Standard? = getSpans(
           editText, attr.start, attr.end,
           AlignmentSpan.Standard::class.java
       )
        return if (centerSpan == null) {
            false
        } else {
            true
        }
    }


    fun  hasOrderListSpan(rxMDEditText: RxMDEditText, start: Int, end: Int): Boolean {
        val orderListSpan = getSpans(
            rxMDEditText, attr.start, attr.end,
            MDOrderListSpan::class.java
        )
        if (orderListSpan == null) {
            return false;
        } else {
            return true;
        }
    }
        fun hasUnOrderListSpan(rxMDEditText: RxMDEditText, start: Int, end: Int): Boolean {
            val unOrderListSpan = getSpans(
                rxMDEditText, attr.start, attr.end,
                MDUnOrderListSpan::class.java
            )
            return if (unOrderListSpan == null) {
                false
            } else {
                true
            }
        }


         fun  hasTodoDone(rxMDEditText: RxMDEditText, start: Int): Boolean {
             val charSequence =
                 rxMDEditText.text.subSequence(attr.start, attr.start + "- [x] ".length)
             return if (charSequence.toString().equals("- [x] ", ignoreCase = true)) {
                 true
             } else {
                 false
             }
        }





        fun   safePosition(position: Int, s: CharSequence): Int {
            return TextHelper.safePosition(position, s);
        }
}