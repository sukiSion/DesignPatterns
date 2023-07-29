package com.example.designpatternsapp.abstractfactorymodel.theme

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import androidx.annotation.ColorRes
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.designpatternsapp.R

abstract class ThemeToolBar: Toolbar {
    constructor(context: Context) : super(context){
        init()
    }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private fun init(){
        setNavigationIcon(initIcon())
        setBackgroundColor(initBackgroundColor())
        setTitleTextColor(initTitleTextColor())
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

    }

    abstract fun initIcon(): Int
    abstract fun initTitleTextColor(): Int
    abstract fun initBackgroundColor(): Int
}

class LightToolBar(context: Context):ThemeToolBar(context){
    override fun initIcon(): Int  = R.drawable.back_black

    override fun initTitleTextColor(): Int = Color.BLACK

    override fun initBackgroundColor(): Int = Color.WHITE
}

class DarkToolBar(context: Context):ThemeToolBar(context){
    override fun initIcon(): Int  = R.drawable.back_white

    override fun initTitleTextColor(): Int = Color.WHITE

    override fun initBackgroundColor(): Int = Color.BLACK
}