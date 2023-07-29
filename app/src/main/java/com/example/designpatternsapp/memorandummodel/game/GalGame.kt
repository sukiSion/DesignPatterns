package com.example.designpatternsapp.memorandummodel.game

import android.util.Log

data class GalGame(
    private var progress: Int = 0,
    private var roleRouter: String = "",
    private var achievement: List<String> = listOf()
) {


    fun rnterHeroine1(){
        progress = 20
        roleRouter = "NaNaMi"
        achievement = listOf("rnterHeroine1")
        Log.e("galgame" , "进入第一位女主角线路：${toString()}")
    }

    fun rnterTureHeroine(){
        progress = 70
        roleRouter = "NaNaKa"
        achievement = listOf("rnterHeroine1" , "rnterHeroine2" , "rnterHeroine3" , "rnterTrueHeroine")
        Log.e("galgame" , "进入真正女主角线路：${toString()}")
    }

    fun quit(){
        Log.e("galgame" , "退出游戏：${toString()}")
    }



    fun createArchive() = Archive(
        progress, roleRouter, achievement
    )

    fun readArchive(archive: Archive){
        progress = archive.progress
        roleRouter = archive.roleRouter
        achievement = archive.achievement
        Log.e("galgame" , "读取存档：${toString()}")
    }

}