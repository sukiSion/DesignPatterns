package com.example.designpatternsapp.visitormodel

class BusinessReport {
    private val mStaff: List<Staff>
    init {
        mStaff = mutableListOf<Staff>().apply {
            add(Manager("王经理"))
            add(Engineer("工程师-Shawn.Xiong"))
            add(Engineer("工程师-Kael"))
            add(Engineer("工程师-Chaossss"))
            add(Engineer("工程师-Tiiime"))
        }
    }

    fun showReport(visitor: Visitor){
        mStaff.forEach {
            it.accept(visitor)
        }
    }

}