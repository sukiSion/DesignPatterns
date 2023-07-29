package com.example.designpatternsapp.flyweightmodel.ticket

import android.util.Log
import kotlin.random.Random

interface Ticket {
    fun showTickInfo()
}

class TrainTicket(
    private val from: String,
    private val to: String,
    private val bunk: String,
): Ticket{
    private val price:Int
    init {
        price = when(bunk){
            "上铺" -> 150
            "下铺" -> 100
            else -> 50
        }
    }

    override fun showTickInfo() {
        Log.e("ticket" , "购买从${from}到${to}的${bunk}火车票价格: $price")
    }
}

