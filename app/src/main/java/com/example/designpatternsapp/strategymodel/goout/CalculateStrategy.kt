package com.example.designpatternsapp.strategymodel.goout

import androidx.annotation.IntRange

interface CalculateStrategy {
    fun calculatePrice(km: Int): Int
}

class BusStrategy : CalculateStrategy{

    override fun calculatePrice(@IntRange(from = 0) km: Int): Int {
        if(km <= 10){
            return  1
        }
        val extraPrice = (km - 10) / 5 + (if( (km - 10) % 5 > 0) { 1 } else { 0 })
        return extraPrice + 1
    }
}

class SubwayStrategy : CalculateStrategy{
    override fun calculatePrice(km: Int): Int {
        when{
            km <= 6 -> {
                return 3
            }
            km in 7 .. 12 -> {
                return 4
            }
            km in 13 .. 22 -> {
                return 5
            }
            km in 23 .. 32 -> {
                return 6
            }
            else ->{
                return 7
            }
        }
    }
}

class TaxiStrategy: CalculateStrategy{
    override fun calculatePrice(km: Int): Int  = km * 2
}
