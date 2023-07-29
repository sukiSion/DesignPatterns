package com.example.designpatternsapp.abstractfactorymodel.car_1

import android.util.Log

interface ITire {
    fun tire()
}

class NormalTire : ITire{
    override fun tire() {
        Log.e("car" , "普通轮胎")
    }
}

class SUVTire: ITire{
    override fun tire() {
        Log.e("car" , "越野轮胎")
    }
}

