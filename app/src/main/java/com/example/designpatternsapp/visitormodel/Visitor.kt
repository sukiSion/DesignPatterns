package com.example.designpatternsapp.visitormodel

import android.util.Log

interface Visitor {
    fun visit(engineer: Engineer)
    fun visit(manager: Manager)
}

class CEOVisitor: Visitor{
    override fun visit(manager: Manager) {
        Log.e("CEO" , "经理 : ${manager.name} , KPI : ${manager.kpi} , 新产品数量 : ${manager.products}")

    }

    override fun visit(engineer: Engineer) {
        Log.e("CEO" , "工程师 : ${engineer.name} , KPI : ${engineer.kpi}")
    }
}

class CTOVisitor: Visitor{
    override fun visit(manager: Manager) {
        Log.e("CTO" , "经理 : ${manager.name} , 新产品数量 : ${manager.products}")

    }

    override fun visit(engineer: Engineer) {
        Log.e("CTO" , "工程师 : ${engineer.name} , 代码函数 : ${engineer.getCodeLines()}")
    }
}