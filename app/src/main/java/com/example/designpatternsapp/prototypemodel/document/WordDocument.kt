package com.example.designpatternsapp.prototypemodel.document

import android.util.Log
import java.lang.Exception

class WordDocument(
    var mText: String,
    private var mImages: ArrayList<String> = ArrayList()
): Cloneable {

    fun showDocument(){
        Log.e("document" , "Word Content Start")
        Log.e("document" , "Text: ${mText}")
        Log.e("document" , "Images: ${mImages}")
        Log.e("document" , "Word Content End")
    }

    fun addImage(image: String){
        mImages.add(image)
    }

    private constructor():this("")

    // clone()方法来源于Object
    // Cloneable是一个标识接口，表明这个对象是可拷贝的
    public override fun clone(): WordDocument {
        try {
            val doc = super.clone() as WordDocument
            doc.mText = this.mText
            // 浅拷贝
//            doc.mImages = this.mImages
            // 深拷贝, 使用了该方法后克隆出来的对象不再是指向本体的引用，建议使用深拷贝
            doc.mImages = this.mImages.clone() as ArrayList<String>
            return doc
        }catch (e: Exception){

        }
        return WordDocument()
    }
}