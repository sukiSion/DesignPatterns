package com.example.designpatternsapp.statemodel.tv

import android.util.Log

interface PowerController {
    fun powerOn()
    fun powerOff()
}

class TvController: PowerController {

    private var mTvState: TvState = PowerOffState()

    override fun powerOff() {
        mTvState = PowerOffState()
        Log.e("tv" , "关机")
    }

    override fun powerOn() {
        mTvState = PowerOnState()
        Log.e("tv" , "开机")
    }

    fun nextChannel(){
        mTvState.nextChannel()
    }

    fun prevChannel(){
        mTvState.prevChannel()
    }

    fun turnUp(){
        mTvState.turnUp()
    }

    fun turnDown(){
        mTvState.turnDown()
    }

}