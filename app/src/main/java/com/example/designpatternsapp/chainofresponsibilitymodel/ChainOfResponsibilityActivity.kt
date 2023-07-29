package com.example.designpatternsapp.chainofresponsibilitymodel

import android.content.ComponentName
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.designpatternsapp.databinding.ActivityChainOfResponsibilityBinding

class ChainOfResponsibilityActivity : AppCompatActivity() {

    private lateinit var activityChainOfResponsibilityBinding: ActivityChainOfResponsibilityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityChainOfResponsibilityBinding = ActivityChainOfResponsibilityBinding.inflate(layoutInflater)
        setContentView(activityChainOfResponsibilityBinding.root)
        registerReceiver(
            ThirdReceiver(),
            IntentFilter().apply {
                addAction("com.designpatternsapp.ORDER_BROADCAST")
                priority = 10
            }
        )
        registerReceiver(
            SecondReceiver(),
            IntentFilter().apply {
                addAction("com.designpatternsapp.ORDER_BROADCAST")
                priority = 100
            }
        )
        registerReceiver(
            FirstReceiver(),
            IntentFilter().apply {
                addAction("com.designpatternsapp.ORDER_BROADCAST")
                priority = IntentFilter.SYSTEM_HIGH_PRIORITY
            }
        )

        activityChainOfResponsibilityBinding.sendBroadcastButton.setOnClickListener {
            sendOrderedBroadcast(
                Intent().apply {
                    action = "com.designpatternsapp.ORDER_BROADCAST"
                    putExtra("limit" , 10)
                    putExtra("msg" , "Message from OrderActivity")
                },
                null
            )
        }
    }
}