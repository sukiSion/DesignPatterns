package com.example.designpatternsapp.ordermodel

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.lang.Exception
import kotlin.concurrent.thread

class BrushSurfaceView: SurfaceView , SurfaceHolder.Callback {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    private var isDrawing: Boolean = false
    private var isRunning: Boolean = false
    private val mInvoke: DrawInvoker
    private var mBitmap: Bitmap? = null
    private val mThread: Thread

    fun setDrawing(boolean: Boolean){
        isDrawing = boolean
    }

    init {
        mInvoke = DrawInvoker()
        holder.addCallback(this)
        mThread = thread(
            start = false
        ) {
            var canvas: Canvas? = null
            while (isRunning){
                if(isDrawing){
                    try {
                        canvas = holder.lockCanvas(null)
                        if(mBitmap == null){
                            mBitmap = Bitmap.createBitmap(
                                1,1,Bitmap.Config.ARGB_8888
                            )
                        }
                        mBitmap?.let {
                            val c = Canvas(it)
                            c.drawColor(Color.WHITE , PorterDuff.Mode.CLEAR)

                            canvas?.drawColor(Color.WHITE , PorterDuff.Mode.CLEAR)
                            mInvoke.excute(c)
                            canvas?.drawBitmap(it , 0f , 0f , null)
                        }
                    }finally {
                        holder.unlockCanvasAndPost(canvas)
                    }
                    isDrawing = false
                }
            }
        }
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        isRunning = true
        mThread.start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        mBitmap = Bitmap.createBitmap(
            width,
            height,
            Bitmap.Config.ARGB_8888
        )
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        isRunning = false
        var retry = true
        while (retry){
            try {
                mThread.join()
                retry = false
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    /**
     * TODO 增减一条路径
     *
     * @param path
     */
    fun add(path: DrawPath){
        mInvoke.add(path)
    }

    /**
     * TODO 重做上一步撤销的操作
     *
     */
    fun redo(){
        isDrawing = true
        mInvoke.redo()
    }

    /**
     * TODO 撤销上一步的操作
     *
     */
    fun undo(){
        mInvoke.undo()
        isDrawing = true
    }

    /**
     * TODO 是否可以撤销
     *
     */
    fun canUndo() = mInvoke.canUndo()

    /**
     * TODO 是否可以重做
     *
     */
    fun canRedo() = mInvoke.canRedo()
}