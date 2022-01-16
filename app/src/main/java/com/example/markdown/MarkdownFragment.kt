package com.example.markdown

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation


class MarkdownFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_markdown, container, false)
        val add = v.findViewById<TextView>(R.id.add)


        add.setOnClickListener {
            val action =  MarkdownFragmentDirections.actionHtmlToAddMarkdown()
            val navController = Navigation.findNavController(requireView())
            navController.navigate(action)
           // activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment,AddMarkdown(),"Now")?.addToBackStack(null)?.commit()
        }

        return v
    }


}