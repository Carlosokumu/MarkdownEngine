package com.example.markdown.view

import android.R
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.widget.PopupMenu
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.assist.QueueProcessingType
import java.io.File


class ImageDialogView : LinearLayout,View.OnClickListener, PopupMenu.OnMenuItemClickListener {


    private var mWidthEditText: EditText? = null
    private var mHeightEditText: EditText? = null
    private var mDescriptionEditText: EditText? = null
    private var mTargetImageView: ImageView? = null
    private var mPath: String? = null
    private var mCurrentCameraPictureIndex = 0





    companion object {
        private const val REQUEST_CAMERA = 10
        private const val REQUEST_GALLERY = 11
        private val DEFAULT_PATH = "drawable://" + R.mipmap.ic_launcher


    }


    private fun init(context: Context) {
        val v: View = LayoutInflater.from(context).inflate(R.layout.dialog_image, this, true)
        mTargetImageView = v.findViewById(R.id.img_image) as ImageView
        mTargetImageView!!.setOnClickListener(this)
        mWidthEditText = v.findViewById(R.id.edit_width) as EditText
        mHeightEditText = v.findViewById(R.id.edit_height) as EditText
        mDescriptionEditText = v.findViewById(R.id.edit_description) as EditText
        if (!ImageLoader.getInstance().isInited()) {
            val config: ImageLoaderConfiguration.Builder = ImageLoaderConfiguration.Builder(
                mTargetImageView!!.getContext()
            )
            config.threadPriority(Thread.NORM_PRIORITY - 2)
            config.denyCacheImageMultipleSizesInMemory()
            config.diskCacheSize(50 * 1024 * 1024)
            config.tasksProcessingOrder(QueueProcessingType.LIFO)
            config.writeDebugLogs()
            ImageLoader.getInstance().init(config.build())
        }
    }



    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ){
        init(context)
    }



    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet){
        init(context)
    }
    constructor(context: Context) : super(context){
        init(context)
    }

    override fun onClick(p0: View?) {
        val popup = PopupMenu(
            context,
            mTargetImageView!!
        )
        val inflater = popup.menuInflater
        inflater.inflate(R.menu.menu_popup, popup.menu)
        popup.setOnMenuItemClickListener(this)
        popup.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean{

        var activity: Activity? = null
        activity = if (context is Activity) {
            context as Activity
        } else {
            Log.e("Carlos", "not activity")
            return false
        }
        when (item!!.itemId) {
            R.id.action_gallery -> {
                val albumIntent = Intent(Intent.ACTION_PICK, null)
                albumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
                activity.startActivityForResult(albumIntent, REQUEST_GALLERY)
            }
            R.id.action_camera -> {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                val file =
                    File(context.externalCacheDir!!.absolutePath + File.separator + "tmp" + mCurrentCameraPictureIndex + ".jpg")
                if (file.exists()) {
                    file.delete()
                }
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file))
                activity!!.startActivityForResult(intent, REQUEST_CAMERA)
            }
        }
        return false
    }


    fun clear() {
        ImageLoader.getInstance().displayImage(DEFAULT_PATH, mTargetImageView)
        mWidthEditText!!.setText("200")
        mHeightEditText!!.setText("200")
        mPath = DEFAULT_PATH
    }


    fun getImageWidth(): Int {
        return mWidthEditText!!.text.toString().toInt()
    }

    fun getImageHeight(): Int {
        return mHeightEditText!!.text.toString().toInt()
    }

    fun getPath(): String? {
        return mPath
    }

    fun getDescription(): String? {
        return mDescriptionEditText!!.text.toString()
    }


    fun handleResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CAMERA && resultCode == Activity.RESULT_OK) {
            mPath =
                "file:/" + context.externalCacheDir!!.absolutePath + File.separator + "tmp" + mCurrentCameraPictureIndex + ".jpg"
            ImageLoader.getInstance().displayImage(mPath, mTargetImageView)
            mCurrentCameraPictureIndex++
        } else if (requestCode == REQUEST_GALLERY && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                return
            }
            val uri: Uri = data.data!!
            val proj = arrayOf(MediaStore.Images.Media.DATA)
            val cursor: Cursor? = mTargetImageView!!.context.contentResolver.query(
                uri,
                proj,
                null,
                null,
                null
            )
            if (cursor!!.moveToFirst()) {
                val column_index: Int = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                mPath = "file:/" + cursor.getString(column_index)
            }
            cursor.close()
            ImageLoader.getInstance().displayImage(mPath, mTargetImageView)
        }
    }


}
