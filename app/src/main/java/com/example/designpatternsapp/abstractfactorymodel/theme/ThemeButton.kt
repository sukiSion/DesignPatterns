package com.example.designpatternsapp.abstractfactorymodel.theme

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

abstract class ThemeButton: AppCompatButton {
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
        setTextColor(initTextColor())
        setBackgroundColor(initBackgroundColor())
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

    }

    abstract fun initTextColor(): Int
    abstract fun initBackgroundColor(): Int
}

class DarkButton(context: Context): ThemeButton(context){
    override fun initTextColor(): Int = Color.WHITE

    override fun initBackgroundColor(): Int = Color.BLACK

}

class LightButton(context: Context): ThemeButton(context){
    override fun initTextColor(): Int = Color.BLACK

    override fun initBackgroundColor(): Int = Color.WHITE

}