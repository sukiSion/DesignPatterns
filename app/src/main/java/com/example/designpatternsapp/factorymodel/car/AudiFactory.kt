package com.example.designpatternsapp.factorymodel.car

import java.lang.Exception

abstract class AudiFactory {
    abstract  fun < T: AudiCar> createAudiCar(clz : Class<T>): T?
}

class AudiCarFactory: AudiFactory(){
    override fun <T : AudiCar> createAudiCar(clz: Class<T>) : T?{
        try{
            val audiCar = Class.forName(clz.name).newInstance() as T
            return audiCar
        }catch (e: Exception){
            e.printStackTrace()
        }
        return null
    }
}