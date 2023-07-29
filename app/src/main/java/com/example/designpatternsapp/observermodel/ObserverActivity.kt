package com.example.designpatternsapp.observermodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityObserverBinding
import com.example.designpatternsapp.observermodel.AndroidEventBus.EventBus
import com.example.designpatternsapp.observermodel.AndroidEventBus.Subscriber

class ObserverActivity : AppCompatActivity() {
    private lateinit var activityObserverBinding: ActivityObserverBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityObserverBinding = ActivityObserverBinding.inflate(layoutInflater)
        setContentView(activityObserverBinding.root)
        activityObserverBinding.publicButton.setOnClickListener {
//            val mrsimple = Coder("mr.simple")
//            val coder1 = Coder("Coder-1")
//            val coder2 = Coder("Coder-2")
//            val coder3 = Coder("Coder-3")
//            DevTechFrontier().apply {
//                addObserver(coder3)
//                addObserver(coder2)
//                addObserver(coder1)
//                addObserver(mrsimple)
//                postNewPublication("新的一期开发技术前线周报发布啦！")
//
//
//            }
            EventBus.getDefault().post("Sion")
        }
        EventBus.getDefault().register(this)
    }

    @Subscriber
    fun handleEvent(value: String){
        Log.e("EventBus" , value)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}