package com.example.designpatternsapp.flyweightmodel.ticket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityTicketBinding

class TicketActivity : AppCompatActivity() {
    private lateinit var activityTicketBinding: ActivityTicketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityTicketBinding = ActivityTicketBinding.inflate(layoutInflater)
        setContentView(activityTicketBinding.root)
        activityTicketBinding.apply {
            buyTopBunkButton.setOnClickListener {
                TicketFactory.getTiack(
                    "北京" , "青岛" , "上铺"
                ).showTickInfo()
            }
            buyBottomBunkButton.setOnClickListener {
                TicketFactory.getTiack(
                    "北京" , "青岛" , "下铺"
                ).showTickInfo()
            }
            buySeatButton.setOnClickListener {
                TicketFactory.getTiack(
                    "北京" , "青岛" , "坐票"
                ).showTickInfo()
            }
            stringEqualButton.setOnClickListener {
                val str1 = String(charArrayOf('a' , 'b' , 'c'))
                val str2 = String(charArrayOf('a' , 'b' , 'c'))
                Log.e("Sion" , "${str1 == str2}")
            }
        }
    }
}