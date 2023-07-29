package com.example.designpatternsapp.proxymodel.lawsuit

import android.util.Log

interface ILawsuit {

    fun litigate(){
        submit()
        burden()
        defend()
        finish()
    }

    fun submit()
    fun burden()
    fun defend()
    fun finish()

}

class XiaoMin : ILawsuit{
    override fun submit() {
        Log.e("lawsuit" , "提交诉讼")
    }

    override fun burden() {
        Log.e("lawsuit" , "提交证据")
    }

    override fun defend() {
        Log.e("lawsuit" , "证据确凿")
    }

    override fun finish() {
        Log.e("lawsuit" , "诉讼成功")
    }
}

class Lawyer(
    private val xiaoMin: XiaoMin
) : ILawsuit{
    override fun submit() {
        xiaoMin.submit()
    }

    override fun burden() {
        xiaoMin.burden()
    }

    override fun defend() {
        xiaoMin.defend()
    }

    override fun finish() {
        xiaoMin.finish()
    }


}

