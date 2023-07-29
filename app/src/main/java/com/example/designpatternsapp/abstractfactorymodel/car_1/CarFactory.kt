package com.example.designpatternsapp.abstractfactorymodel.car_1

interface CarFactory {
    fun createTire(): ITire
    fun createEngine(): IEngine
    fun createBrake(): IBrake
}

class Q3Factory: CarFactory{
    override fun createTire(): ITire = NormalTire()

    override fun createEngine(): IEngine = DomesticEngine()

    override fun createBrake(): IBrake = NormalBrake()
}

class Q7Factory: CarFactory{
    override fun createTire(): ITire = SUVTire()

    override fun createEngine(): IEngine = ImportEngine()

    override fun createBrake(): IBrake = SeniorBrake()
}