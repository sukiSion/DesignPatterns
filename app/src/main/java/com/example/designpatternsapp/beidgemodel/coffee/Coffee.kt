package com.example.designpatternsapp.beidgemodel.coffee

import android.util.Log

abstract class Coffee(
    protected val coffeeAdditives: CoffeeAdditives
) {
    abstract fun makeCoffee()
}

class LargrCoffee(coffeeAdditives: CoffeeAdditives): Coffee(coffeeAdditives){
    override fun makeCoffee() {
        Log.e("coffee" , "大杯${coffeeAdditives.doSomething()}")
    }
}

class SmallCoffee(coffeeAdditives: CoffeeAdditives): Coffee(coffeeAdditives){
    override fun makeCoffee() {
        Log.e("coffee" , "小杯${coffeeAdditives.doSomething()}")
    }
}

class MiddleCoffee(coffeeAdditives: CoffeeAdditives): Coffee(coffeeAdditives){
    override fun makeCoffee() {
        Log.e("coffee" , "中杯${coffeeAdditives.doSomething()}")
    }
}

