package com.example.designpatternsapp.memorandummodel.note

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText

class NoteEditText: AppCompatEditText {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun createMemoto(): Memoto{
        return Memoto(
            text = "${text}",
            // selectionStart:返回选择锚点或光标的偏移量，如果没有选择项或光标，则返回 -1。
            cursor = selectionStart
        )
    }

    fun restore(memoto: Memoto){
        setText(memoto.getText())
        // 将光标移至偏移索引
        setSelection(memoto.getCursor())
    }
}