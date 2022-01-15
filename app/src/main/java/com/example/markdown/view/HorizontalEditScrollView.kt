package com.example.markdown.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.markdown.R
import com.example.markdown.controller.*
import com.yydcdut.markdown.MarkdownConfiguration
import com.yydcdut.markdown.MarkdownEditText


class HorizontalEditScrollView : FrameLayout {
    private var mMarkdownEditText: MarkdownEditText? = null

    private var mHeaderController: HeaderController? = null
    private var mStyleController: StyleController? = null
    private var mCenterAlignController: CenterAlignController? = null
    private var mHorizontalRulesController: HorizontalRulesController? = null
    private var mTodoController: TodoController? = null
    private var mStrikeThroughController: StrikeThroughController? = null
    private var mCodeController: CodeController? = null
    private var mBlockQuotesController: BlockQuotesController? = null
    private var mListController: ListController? = null
    private var mImageController: ImageController? = null
    private var mLinkController: LinkController? = null


     constructor(context: Context): this(context,null)
     constructor (context: Context,attrs: AttributeSet,defStyleAttr: Int): super(context,attrs,defStyleAttr){
         LayoutInflater.from(context).inflate(R.layout.layout_horizontal_scroll, this, true);
     }

     constructor(context: Context, attrs: AttributeSet?): this(context,attrs!!,0)




    fun setEditTextAndConfig(markdownEditText: MarkdownEditText, markdownConfiguration: MarkdownConfiguration) {
        mMarkdownEditText = markdownEditText
        mHeaderController = HeaderController(markdownEditText, markdownConfiguration)
        mStyleController = StyleController(markdownEditText)
        mCenterAlignController = CenterAlignController(markdownEditText)
        mHorizontalRulesController = HorizontalRulesController(markdownEditText)
        mTodoController = TodoController(markdownEditText)
        mStrikeThroughController = StrikeThroughController(markdownEditText)
        mCodeController = CodeController(markdownEditText)
        mBlockQuotesController = BlockQuotesController(markdownEditText)
        mListController = ListController(markdownEditText)
        mImageController = ImageController(markdownEditText)
        mLinkController = LinkController(markdownEditText)
    }




}