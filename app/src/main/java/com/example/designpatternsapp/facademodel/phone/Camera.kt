package com.example.designpatternsapp.facademodel.phone

import android.util.Log

interface Camera {
    fun open()
    fun takePicture()
    fun close()
}

class CameraImpl: Camera{
    override fun open() {
        Log.e("camera" , "打开相机")
    }

    override fun takePicture() {
        Log.e("camera" , "拍照")
    }

    override fun close() {
        Log.e("camera" , "关闭相机")
    }
}