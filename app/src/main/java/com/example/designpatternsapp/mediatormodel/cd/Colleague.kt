package com.example.designpatternsapp.mediatormodel.cd

import android.util.Log

abstract class Colleague(
    private val mediator: Mediator
)

class CPU(
    private val mediator: Mediator,
    var dataVideo: String = "",
    var dataSound: String = ""
    ) : Colleague(mediator){

    fun decodeData(data: String){

        val tmp = data.split(",")
        dataVideo = tmp[0]
        dataSound = tmp[1]
        // 告诉中介者自身状态改变
        mediator.change(this)
    }
}


class CDDevice(
    private val mediator: Mediator,
    private var data:String = ""
    ):Colleague(
    mediator
){
    fun getData() = data

    fun load(){
        this.data = "播放视频,播放音频"
        mediator.change(this)
    }
}


class GraphiceCard(
    private val mediator: Mediator,
): Colleague(mediator){
    fun videoPlay(dataVideo: String){
        Log.e("cd" , "播放视频")
    }
}


class SoundCard(
    private val mediator: Mediator,
): Colleague(mediator){
    fun soundPlay(dataSound: String){
        Log.e("cd" , "播放音频")
    }
}