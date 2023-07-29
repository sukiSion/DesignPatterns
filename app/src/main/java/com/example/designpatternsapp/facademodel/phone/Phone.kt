package com.example.designpatternsapp.facademodel.phone

import android.util.Log

interface Phone {
    fun dail()
    fun hangUp()
}

class PhoneImpl : Phone{
    override fun dail() {
        Log.e("phone" , "打电话")
    }

    override fun hangUp() {
        Log.e("phone" , "挂断电话")
    }
}

