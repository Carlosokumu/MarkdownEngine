package com.example.markdown.view

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import com.example.markdown.R
import com.example.markdown.controller.*
import com.yydcdut.markdown.MarkdownConfiguration
import com.yydcdut.markdown.MarkdownEditText


class HorizontalEditScrollView : FrameLayout, View.OnClickListener, View.OnLongClickListener {
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
    private var view: View? = null






     constructor (context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(
         context,
         attrs,
         defStyleAttr
     ){
        view = LayoutInflater.from(context).inflate(R.layout.layout_horizontal_scroll, this, true);
     }

     constructor(context: Context, attrs: AttributeSet?): this(context, attrs!!, 0)




    fun setEditTextAndConfig(
        markdownEditText: MarkdownEditText,
        markdownConfiguration: MarkdownConfiguration
    ) {
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


    override fun onFinishInflate() {
        super.onFinishInflate()
        findViewById<ImageView>(R.id.img_header1).setOnClickListener(this);
        view!!.findViewById<ImageView>(R.id.img_header2).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_header3).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_header4).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_header5).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_header6).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_bold).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_italic).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_center_align).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_todo).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_todo_done).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_strike_through).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_inline_code).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_code).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_block_quote).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_block_quote).setOnLongClickListener(this);
        findViewById<ImageView>(R.id.img_unorder_list).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_order_list).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_link).setOnClickListener(this);
        findViewById<ImageView>(R.id.img_photo).setOnClickListener(this);
    }

    override fun onClick(v: View) {
        if (mMarkdownEditText == null) {
            return
        }
        when (v.getId()) {
            R.id.img_header1 -> {
                mHeaderController!!.doHeader(1)
            }
            R.id.img_header2 ->{
                mHeaderController!!.doHeader(2)
            }
            R.id.img_header3 -> mHeaderController!!.doHeader(3)
            R.id.img_header4 -> mHeaderController!!.doHeader(4)
            R.id.img_header5 -> mHeaderController!!.doHeader(5)
            R.id.img_header6 -> mHeaderController!!.doHeader(6)
            R.id.img_bold -> mStyleController!!.doBold()
            R.id.img_italic -> mStyleController!!.doItalic()
            R.id.img_center_align -> mCenterAlignController!!.doCenter()
            R.id.img_horizontal_rules -> mHorizontalRulesController!!.doHorizontalRules()
            R.id.img_todo -> mTodoController!!.doTodo()
            R.id.img_todo_done -> mTodoController!!.doTodoDone()
            R.id.img_strike_through -> mStrikeThroughController!!.doStrikeThrough()
            R.id.img_inline_code -> mCodeController!!.doInlineCode()
            R.id.img_code -> mCodeController!!.doCode()
            R.id.img_block_quote -> mBlockQuotesController!!.doBlockQuotes()
            R.id.img_unorder_list -> mListController!!.doUnOrderList()
            R.id.img_order_list -> mListController!!.doOrderList()
            R.id.img_link -> mLinkController!!.doImage()
            R.id.img_photo -> mImageController!!.doImage()
        }
    }

    override fun onLongClick(v: View): Boolean {
        when (v.getId()) {
            R.id.img_block_quote -> mBlockQuotesController!!.addNestedBlockQuotes()
        }
        return true
    }


    fun handleResult(requestCode: Int, resultCode: Int, data: Intent?) {
        mImageController!!.handleResult(requestCode, resultCode, data)
    }


}