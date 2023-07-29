package com.example.designpatternsapp.visitormodel

import kotlin.random.Random

abstract class Staff(
    val name: String,
    val kpi: Int = Random.nextInt(10)
) {
    abstract fun accept(visitor: Visitor)
}

class Engineer(
    name: String
) : Staff(name = name){

    fun getCodeLines() = Random.nextInt(10 * 10000)

    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

class Manager(
    name: String,
    val products: Int = Random.nextInt(10)
) : Staff(name = name){

    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}