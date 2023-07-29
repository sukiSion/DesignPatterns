package com.example.designpatternsapp.flyweightmodel.ticket

import android.util.Log
import java.util.concurrent.ConcurrentHashMap

class TicketFactory {
    companion object{
        private val mTickMap: MutableMap<String , Ticket> = ConcurrentHashMap()
        fun getTiack(from: String , to: String , bunk: String): Ticket{
            val key = "${from}-${to}-${bunk}"
            if(mTickMap.containsKey(key)){
                Log.e("ticket" , "使用缓存: ${key}")
                return mTickMap.getOrElse(key){
                    return TrainTicket(
                        from , to , bunk
                    )
                }
            }else{
                Log.e("ticket" , "创建对象: ${key}")
                val trainTicket = TrainTicket(from, to, bunk)
                mTickMap.put(key , trainTicket)
                return trainTicket
            }
        }
    }


}