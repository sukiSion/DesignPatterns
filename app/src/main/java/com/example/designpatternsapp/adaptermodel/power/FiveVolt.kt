package com.example.designpatternsapp.adaptermodel.power

interface FiveVolt {
    fun getVolt5(): Int
}

open class Volt220{
    fun getVolt220() = 220
}

class VoltAdapter : FiveVolt , Volt220(){
    override fun getVolt5() = 5
}

class VoltAdapter1(
    private val volt220: Volt220
): FiveVolt{

    override fun getVolt5(): Int = 5
    fun getVolt220() = volt220.getVolt220()

}