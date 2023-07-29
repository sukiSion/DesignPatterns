package com.example.designpatternsapp.adaptermodel.circlr

import android.content.Context
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.BaseAdapter
import android.widget.ListAdapter
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ItemCircleMenuBinding
import kotlin.math.round


class CirclrMenuLayout: ViewGroup {
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

    init {
        setPadding(0 , 0 , 0 ,0)
    }

    companion object{
        const val RADIO_DEFAULT_CHILD_DIMENSION = 1 / 4f
        const val RADIO_PADDING_LAYOUT = 1 / 12f
    }

    private var mRadius = 0f
    private var mStartAngle: Double = 0.00
    private var mPadding = 0f
    private lateinit var mItemTexts: Array<String>
    private lateinit var mItemImgs: IntArray
    private var onItemClickListener: ((view: View , index: Int) -> Unit)? = null
    private var mMenuItemLayoutId = R.layout.item_circle_menu
    private var mItemCount: Int = 0
    private lateinit var mAdapter: BaseAdapter

    fun setMenuItemIconsAndTexts(images: IntArray, texts: Array<String>){
        if(images.size != texts.size){
            throw IllegalArgumentException("菜单图片与文本数量应该一致")
        }
        mItemImgs = images
        mItemTexts = texts
        mItemCount = images.size

//        buildMenuItems()
    }

    fun setOnItemClickListener(
        callback: (view: View , index: Int) -> Unit
    ){
        onItemClickListener = callback
    }

    fun setMenuItemLayout(mMenuItemLayoutId: Int){
        this.mMenuItemLayoutId = mMenuItemLayoutId
    }

    override fun onAttachedToWindow() {
        buildMenuItems()
        super.onAttachedToWindow()
    }

    fun setAdapter(adapter: BaseAdapter){
        mAdapter = adapter
    }


    private fun buildMenuItems(){
        for(index in 0 until mAdapter.count){
//            inflateMenuView(index).apply {
//                initMenuItem(this , index)
                val itemView = mAdapter.getView(index , null , this@CirclrMenuLayout)
                itemView.setOnClickListener {
                    onItemClickListener?.apply {
                        this(it , index)
                    }
                }
                addView(itemView)
            }
//        }
    }

    private fun inflateMenuView(childIndex: Int): ItemCircleMenuBinding{
        val layoutInflater = LayoutInflater.from(context)
        val itemView = ItemCircleMenuBinding.inflate(
            layoutInflater,
            this,
            false
        )
        itemView.root.setOnClickListener {
            onItemClickListener?.apply {
                this(it , childIndex)
            }
        }

        return itemView
    }

    private fun initMenuItem(itemCircleMenuBinding: ItemCircleMenuBinding , childIndex: Int){
        itemCircleMenuBinding.itemCircleMenuImage.apply {
            visibility = VISIBLE
            setImageResource(mItemImgs[childIndex])
        }
        itemCircleMenuBinding.itemCircleMenuText.apply {
            visibility = VISIBLE
            setText(mItemTexts[childIndex])
        }

    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        measureMyself(widthMeasureSpec , heightMeasureSpec)
        measureChildViews()
    }

    private fun measureMyself(widthMeasureSpec: Int , heightMeasureSpec: Int){
        var resWidth = 0
        var resHeight = 0
        val measureWidthModel = MeasureSpec.getMode(widthMeasureSpec)
        val measureWidthSize = MeasureSpec.getSize(widthMeasureSpec)
        val measureHeightModel = MeasureSpec.getMode(heightMeasureSpec)
        val measureHeightSize = MeasureSpec.getSize(heightMeasureSpec)

        if(measureWidthModel != MeasureSpec.EXACTLY || measureHeightModel != MeasureSpec.EXACTLY){
            resWidth = suggestedMinimumWidth
            resWidth = if(resWidth == 0) getDefaultWidth() else resWidth
            resHeight = suggestedMinimumHeight
            resHeight = if(resHeight == 0) getDefaultWidth() else resHeight
        }else{
            // 如果都设置为精确值，则直接取小值；
            resWidth =  minOf(measureWidthSize, measureHeightSize)
            resHeight = minOf(measureWidthSize , measureHeightSize)
        }

        setMeasuredDimension(resWidth, resHeight)
    }

    private fun measureChildViews(){
        mRadius = maxOf(measuredWidth , measuredHeight).toFloat()
        val count = childCount
        val childSize = (mRadius * RADIO_DEFAULT_CHILD_DIMENSION) .toInt()
        val childModel = MeasureSpec.EXACTLY
        for(index in 0 until count){
            val child = getChildAt(index)
            if(child.visibility == View.GONE){
                continue
            }
            var makeMeasureSpec = -1
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(
                childSize,
                childModel
            )
            child.measure(makeMeasureSpec , makeMeasureSpec)
        }
        mPadding = RADIO_PADDING_LAYOUT * mRadius
    }

    /**
     * 获得默认该layout的尺寸
     *
     * @return
     */
    private fun getDefaultWidth(): Int {
        val wm = context.getSystemService(
            Context.WINDOW_SERVICE
        ) as WindowManager
        val outMetrics = DisplayMetrics()
        wm.defaultDisplay.getMetrics(outMetrics)
        return minOf(outMetrics.widthPixels, outMetrics.heightPixels)
    }

    /**
     * 设置内边距的比例
     *
     * @param mPadding
     */
    fun setPadding(mPadding: Float) {
        this.mPadding = mPadding
    }


    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var layoutRadius = mRadius
        var left = 0
        var top = 0
        // menu item 的尺寸
        val cWidth =  (layoutRadius * RADIO_DEFAULT_CHILD_DIMENSION).toInt()
        val count = childCount
        // 根据menu item的个数，计算角度
        val angleDelay = 360 / count
        for(index in 0 until count){
            val child = getChildAt(index)
            if(child.visibility == View.GONE){
                continue
            }
            mStartAngle %= 360
            // tmp cosa 即menu item中心点的横坐标
            val tmp = layoutRadius / 2f - cWidth / 2 - mPadding
            left = (layoutRadius / 2).toInt() + round(
                tmp * Math.cos(Math.toRadians(mStartAngle)) - 1 / 2f * cWidth
            ).toInt()
            // tmp sina 即menu item的纵坐标
            top = (layoutRadius / 2).toInt() + round(
                tmp * Math.sin(Math.toRadians(mStartAngle)) - 1 / 2f * cWidth
            ).toInt()
            child.layout(left, top, left + cWidth, top + cWidth)
            // 叠加尺寸
            mStartAngle += angleDelay
        }
    }
}