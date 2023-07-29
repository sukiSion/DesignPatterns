package com.example.designpatternsapp.beidgemodel.coffee

abstract class CoffeeAdditives {
    abstract fun doSomething(): String
}

class Sugar: CoffeeAdditives(){
    override fun doSomething(): String = "加糖"
}

class Ordinary: CoffeeAdditives(){
    override fun doSomething(): String = "原味"
}