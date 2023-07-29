package com.example.designpatternsapp.factorymodel.car

import android.util.Log

abstract class AudiCar {
    abstract fun drive()
    abstract fun selfNavigation()
}

class AudiQ3: AudiCar(){
    override fun drive() {
        Log.e("audi" , "Q3启动")
    }

    override fun selfNavigation() {
        Log.e("audi" , "Q3开启自动巡航")
    }
}

class AudiQ5: AudiCar(){
    override fun drive() {
        Log.e("audi" , "Q5启动")
    }

    override fun selfNavigation() {
        Log.e("audi" , "Q5开启自动巡航")
    }
}

class AudiQ7: AudiCar(){
    override fun drive() {
        Log.e("audi" , "Q7启动")
    }

    override fun selfNavigation() {
        Log.e("audi" , "Q7开启自动巡航")
    }
}