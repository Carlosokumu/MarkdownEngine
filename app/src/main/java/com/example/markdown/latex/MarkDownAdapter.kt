package com.example.markdown.latex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.markdown.MarkDowns
import com.example.markdown.R
import us.feras.mdv.MarkdownView


object MarkDiffer : DiffUtil.ItemCallback<MarkDowns>() {




    override fun areItemsTheSame(oldItem: MarkDowns, newItem: MarkDowns) =
        oldItem.content == newItem.content

    override fun areContentsTheSame(oldItem: MarkDowns, newItem: MarkDowns) =
        oldItem == newItem
}

class MarkDownAdapter: ListAdapter<MarkDowns, MarkDownAdapter.ViewHolder>(MarkDiffer) {







    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
          val view =LayoutInflater.from(parent.context).inflate(R.layout.markdowncontent,parent,false)
          return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(getItem(position))
    }

    inner  class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(markDowns: MarkDowns){
           val markdownView = itemView.findViewById<MarkdownView>(R.id.markdownView)
            //val type: Any = itemView.context.applicationContext.assets.open( "markdown_css_themes/classic.css")
            markdownView.loadMarkdown(markDowns.content, "file:///android_asset/markdown_css_themes/alt.css")
           // markdownView.loadMarkdownFile(Const.Theme)
            //markdownView.loadMarkdown(Const.Theme)
        }
    }

}