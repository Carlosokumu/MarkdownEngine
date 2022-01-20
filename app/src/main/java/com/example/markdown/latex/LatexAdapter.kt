package com.example.markdown.latex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.markdown.MarkDowns
import com.example.markdown.R
import katex.hourglass.`in`.mathlib.MathView

object MarkDiffers : DiffUtil.ItemCallback<MarkDowns>() {




    override fun areItemsTheSame(oldItem: MarkDowns, newItem: MarkDowns) =
        oldItem.content == newItem.content

    override fun areContentsTheSame(oldItem: MarkDowns, newItem: MarkDowns) =
        oldItem == newItem
}

class LatexAdapter: ListAdapter<MarkDowns, LatexAdapter.ViewHolder>(MarkDiffers) {







    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.latex_layout,parent,false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner  class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(markDowns: MarkDowns){

            val mathView = itemView.findViewById<MathView>(R.id.mathView)

            mathView.setTextSize(14)

            mathView.setTextColor(
                ContextCompat.getColor(
                    itemView.context.applicationContext,
                    android.R.color.black
                )
            )

            //mathView.setDisplayText(Const.MD_SAMPLE)

            mathView.setViewBackgroundColor(
                ContextCompat.getColor(
                    itemView.context.applicationContext,
                    android.R.color.white
                )
            )
            mathView.setDisplayText(markDowns.content)


        }
    }

}