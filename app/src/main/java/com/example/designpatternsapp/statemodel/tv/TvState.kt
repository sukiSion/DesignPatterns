package com.example.designpatternsapp.statemodel.tv

import android.util.Log

interface TvState  {
    fun nextChannel()
    fun prevChannel()
    fun turnUp()
    fun turnDown()
}

class PowerOffState: TvState {
    override fun nextChannel() {
        Log.e("tv" , "关机状态")
    }

    override fun prevChannel() {
        Log.e("tv" , "关机状态")
    }

    override fun turnUp() {
        Log.e("tv" , "关机状态")
    }

    override fun turnDown() {
        Log.e("tv" , "关机状态")
    }
}

class PowerOnState: TvState {
    override fun nextChannel() {
        Log.e("tv" , "下一频道")
    }

    override fun prevChannel() {
        Log.e("tv" , "上一频道")
    }

    override fun turnUp() {
        Log.e("tv" , "调高音量")
    }

    override fun turnDown() {
        Log.e("tv" , "调低音量")
    }
}