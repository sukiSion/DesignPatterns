package com.example.designpatternsapp.abstractfactorymodel.car_1

import android.util.Log

interface IEngine {
    fun engine()
}

class DomesticEngine: IEngine{
    override fun engine() {
        Log.e("car" , "国产发动机")
    }
}

class ImportEngine: IEngine{
    override fun engine() {
        Log.e("car" , "进口发动机")
    }
}
