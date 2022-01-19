package com.example.markdown.fragments


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.markdown.Const
import com.example.markdown.MarKBox
import com.example.markdown.MarkDowns
import com.example.markdown.view.EditScrollView
import com.example.markdown.view.HorizontalEditScrollView
import com.yydcdut.markdown.MarkdownConfiguration
import com.yydcdut.markdown.MarkdownEditText
import com.yydcdut.markdown.MarkdownProcessor
import com.yydcdut.markdown.syntax.edit.EditFactory
import com.yydcdut.rxmarkdown.RxMDEditText
import  com.example.markdown.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sdsmdg.tastytoast.TastyToast


class AddMarkdown : Fragment(), EditScrollView.onScrollChangedListener {


    private var mMarkdownEditText: MarkdownEditText? = null
    private var mMarkdownProcessor: MarkdownProcessor? = null
    private var mHorizontalEditScrollView: HorizontalEditScrollView? = null
    private var floatingActionButton: FloatingActionButton? = null
    private var mShortestDistance = -1
    private  var isRx: Boolean = false




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_add_markdown, container, false)
        val editScrollView = v.findViewById(R.id.edit_scroll) as EditScrollView
        floatingActionButton =v.findViewById(R.id.fab)
        mHorizontalEditScrollView =v.findViewById(R.id.scroll_edit) as HorizontalEditScrollView
        mMarkdownEditText = v.findViewById(R.id.edit_md)
        mMarkdownEditText?.visibility = View.VISIBLE
        if (mMarkdownEditText?.text.toString().length >= 0){
            floatingActionButton?.visibility = View.VISIBLE
        }

        floatingActionButton?.setOnClickListener {

            val  markDown = MarKBox.store.boxFor(MarkDowns::class.java)
            val mMarkdown = MarkDowns(content = mMarkdownEditText?.text.toString())
            markDown.put(mMarkdown)
            AddMarkdownDirections.actionAddMarkdownToHtml()
            TastyToast.makeText(requireContext(), "Successfully added  !", TastyToast.LENGTH_LONG, TastyToast.SUCCESS)
        }

        mMarkdownEditText?.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(char:  CharSequence?, p1: Int, p2: Int, p3: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {



            }

            override fun afterTextChanged(text: Editable?) {

                if (text != null) {
                    if (text.isEmpty()){
                        floatingActionButton?.visibility =View.GONE
                    }
                    else {
                        floatingActionButton?.visibility =View.VISIBLE
                    }
                }


            }

        })
        mMarkdownEditText?.setOnClickListener {

        }
       editScrollView.setOnScrollChangedListener(this)
        markdown()
       return  v

    }


    private fun markdown() {
        val markdownConfiguration = MarkdownConfiguration.Builder(requireContext())
            .setDefaultImageSize(50, 50)
            .setBlockQuotesLineColor(-0xcc4a1b)
            .setHeader1RelativeSize(1.6f)
            .setHeader2RelativeSize(1.5f)
            .setHeader3RelativeSize(1.4f)
            .setHeader4RelativeSize(1.3f)
            .setHeader5RelativeSize(1.2f)
            .setHeader6RelativeSize(1.1f)
            .setHorizontalRulesColor(-0x663400)
            .setCodeBgColor(-0xbbbc)
            .setTodoColor(-0x559934)
            .setTodoDoneColor(-0x7800)
            .setUnOrderListColor(-0xff2201)
            .build()
        if (mMarkdownEditText != null) {
            mHorizontalEditScrollView?.setEditTextAndConfig(mMarkdownEditText!!, markdownConfiguration)
        }
        mMarkdownEditText!!.setText(Const.MD_SAMPLE)
        mMarkdownProcessor = MarkdownProcessor(requireContext())
        mMarkdownProcessor!!.config(markdownConfiguration)
        mMarkdownProcessor!!.factory(EditFactory.create())
        mMarkdownProcessor!!.live(mMarkdownEditText)
    }




    override fun ScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        if (mShortestDistance == -1) {
          //  mShortestDistance = mRxMDEditText?.lineHeight!! * 3 / 2;
        }

    }


}