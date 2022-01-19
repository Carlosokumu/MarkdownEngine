package com.example.markdown.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.markdown.Const
import com.example.markdown.R
import katex.hourglass.`in`.mathlib.MathView


class LaTex : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


      //  val document = MarkdownDocument("file:///android_asset/READ.MD")
        val v = inflater.inflate(R.layout.fragment_la_tex, container, false)
       // val mathView = v.findViewById<MTMathView>(R.id.mathview)
       // mathView.latex = "x = \\frac{-b \\pm \\sqrt{b^2-4ac}}{2a}"
        val parent_layout = v.findViewById<RelativeLayout>(R.id.parent_layout)
        val mathView = MathView(requireContext().applicationContext)

        mathView.isClickable = true

        mathView.setTextSize(14)

        mathView.setTextColor(
            ContextCompat.getColor(
                 requireContext().applicationContext,
                android.R.color.black
            )
        )

        mathView.setDisplayText(Const.MD_SAMPLE)

        mathView.setViewBackgroundColor(
            ContextCompat.getColor(
                requireContext().applicationContext,
                android.R.color.white
            )
        )

        parent_layout.addView(mathView)
        return v

    }


}