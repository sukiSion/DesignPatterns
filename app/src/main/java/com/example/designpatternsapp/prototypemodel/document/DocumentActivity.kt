package com.example.designpatternsapp.prototypemodel.document

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityDocumentBinding

class DocumentActivity : AppCompatActivity() {
    private lateinit var activityDocumentBinding: ActivityDocumentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDocumentBinding = ActivityDocumentBinding.inflate(layoutInflater)
        setContentView(activityDocumentBinding.root)

        val wordDocument = WordDocument("这是一篇文档").apply {
            addImage("图片1")
            addImage("图片2")
            addImage("图片3")
        }


        activityDocumentBinding.apply {
            shallowCopyButton.setOnClickListener {
                wordDocument.clone().apply {
                    wordDocument.showDocument()
                    showDocument()
                    mText = "这是修改过的doc1文档"
                    showDocument()
                    wordDocument.showDocument()
                }
            }
            deepCopyButton.setOnClickListener {
                wordDocument.clone().apply {
                    wordDocument.showDocument()
                    showDocument()
                    mText = "这是修改过的doc1文档"
                    addImage("图片4")
                    showDocument()
                    wordDocument.showDocument()
                }
            }
        }
    }
}