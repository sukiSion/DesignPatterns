package com.example.designpatternsapp.adaptermodel.power

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityVoltBinding

class VoltActivity : AppCompatActivity() {
    private lateinit var activityVoltBinding: ActivityVoltBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityVoltBinding = ActivityVoltBinding.inflate(layoutInflater)
        setContentView(activityVoltBinding.root)
        val voltAdapter = VoltAdapter()
        activityVoltBinding.outputVoltButton.setOnClickListener {
            Log.e("volt" , "${voltAdapter.getVolt5()}")
        }
    }
}