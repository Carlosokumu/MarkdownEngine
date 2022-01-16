package com.example.markdown


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.markdown.view.EditScrollView
import com.example.markdown.view.HorizontalEditScrollView
import com.yydcdut.markdown.MarkdownConfiguration
import com.yydcdut.markdown.MarkdownEditText
import com.yydcdut.markdown.MarkdownProcessor
import com.yydcdut.markdown.syntax.edit.EditFactory
import com.yydcdut.rxmarkdown.RxMDEditText
import  com.example.markdown.R


class AddMarkdown : Fragment(), EditScrollView.onScrollChangedListener {
    private val mRxMDEditText: RxMDEditText? = null
    private var mMarkdownEditText: MarkdownEditText? = null
    private var mMarkdownProcessor: MarkdownProcessor? = null
    private val mHorizontalEditScrollView: HorizontalEditScrollView? = null
    private var mShortestDistance = -1
    private  var isRx: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_add_markdown, container, false)
        val editScrollView = v.findViewById(R.id.edit_scroll) as EditScrollView
        mMarkdownEditText = v.findViewById(R.id.edit_md)
       // mRxMDEditText = v.findViewById(R.id.edit_rx)
       editScrollView.setOnScrollChangedListener(this)
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
            mShortestDistance = mRxMDEditText?.lineHeight!! * 3 / 2;
        }

    }


}