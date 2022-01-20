package com.example.markdown.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.markdown.smalldb.MarKBox
import com.example.markdown.R
import com.example.markdown.helpers.SpaceItemDecoration
import com.example.markdown.latex.LatexAdapter


class LaTex : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val v = inflater.inflate(R.layout.fragment_la_tex, container, false)


        val latexRecycler = v.findViewById<RecyclerView>(R.id.laTexRecyclerView)

        latexRecycler.addItemDecoration(SpaceItemDecoration(
            resources.getDimension(R.dimen.margin_small).toInt(),
            resources.getDimension(R.dimen.margin).toInt())
        )
        val adapter = LatexAdapter()


        adapter.submitList(MarKBox.getContents())
        latexRecycler.adapter = adapter


        if (MarKBox.getContents().isEmpty()){
            v.findViewById<LottieAnimationView>(R.id.empty)?.visibility = View.VISIBLE
        }

        else {

            LatexAdapter().submitList(MarKBox.getContents())
        }
        /*
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

         */
        return v

    }


}