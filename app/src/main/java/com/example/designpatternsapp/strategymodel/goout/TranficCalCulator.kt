package com.example.designpatternsapp.strategymodel.goout

class TranficCalCulator(private val calculateStrategy: CalculateStrategy) {
    fun calcuatePrice(km: Int): Int = calculateStrategy.calculatePrice(km)
}