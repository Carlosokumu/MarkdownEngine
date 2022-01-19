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


        val v = inflater.inflate(R.layout.fragment_la_tex, container, false)

        val parentLayout = v.findViewById<RelativeLayout>(R.id.parent_layout)
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

        parentLayout.addView(mathView)
        return v

    }


}