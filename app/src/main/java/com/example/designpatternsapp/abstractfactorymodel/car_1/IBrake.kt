package com.example.designpatternsapp.abstractfactorymodel.car_1

import android.util.Log

interface IBrake {
    fun brake()
}

class NormalBrake: IBrake{
    override fun brake() {
        Log.e("car" , "普通制动")
    }
}

class SeniorBrake: IBrake{
    override fun brake() {
        Log.e("car" , "高级制动")
    }
}