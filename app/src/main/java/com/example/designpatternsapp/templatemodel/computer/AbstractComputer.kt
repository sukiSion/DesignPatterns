package com.example.designpatternsapp.templatemodel.computer

import android.util.Log

abstract class AbstractComputer{
    protected fun power(){
        Log.e("Computer" , "开启电源")
    }

    protected open fun checkHardWare(){
        Log.e("Computer" , "硬件检查")
    }

    protected fun loadOS(){
        Log.e("Computer" , "载入操作系统")
    }

    protected abstract fun login()

    fun startUp(){
        power()
        checkHardWare()
        loadOS()
        login()
    }
}

class CoderComputer : AbstractComputer(){
    override fun login() {
        Log.e("CoderComputer" , "程序员只需要进行用户和密码验证就可以了")
    }
}

class MilitaryComputer: AbstractComputer(){
    override fun login() {
        Log.e("MilitaryComputer" , "进行指纹识别等复杂的用户验证")
    }

    override fun checkHardWare(){
        super.checkHardWare()
        Log.e("MilitaryComputer" , "检查硬件防火墙")
    }
}



