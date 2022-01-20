package com.example.markdown.fragments

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.markdown.*
import com.example.markdown.latex.MarkDownAdapter
import com.example.markdown.smalldb.MarKBox
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MarkdownFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_markdown, container, false)
        val add = v.findViewById<TextView>(R.id.add)
        val markRecycler = v.findViewById<RecyclerView>(R.id.markRecyclerView)
        val empty = v.findViewById<LinearLayout>(R.id.empty)
        val fab = v.findViewById<FloatingActionButton>(R.id.fab)

        add.text = Html.fromHtml(getString(R.string.add))
        val  markDowns = MarKBox.store.boxFor(MarkDowns::class.java).all
        if (markDowns.isEmpty()){
            empty.visibility = View.VISIBLE
            markRecycler.visibility = View.GONE
        }

        val adapter = MarkDownAdapter()
        adapter.submitList(markDowns)
        markRecycler.adapter  = adapter
        fab.setOnClickListener {
            val action = MarkdownFragmentDirections.actionHtmlToAddMarkdown()
            val navController = Navigation.findNavController(requireView())
            navController.navigate(action)

        }

        return v
    }


}