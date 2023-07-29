package com.example.designpatternsapp.abstractfactorymodel.car_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityCarSecondBinding

class CarSecondActivity : AppCompatActivity() {
    private lateinit var activityCarSecondBinding: ActivityCarSecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCarSecondBinding = ActivityCarSecondBinding.inflate(layoutInflater)
        setContentView(activityCarSecondBinding.root)
        val q3Factory = Q3Factory()
        val q7Factory = Q7Factory()
        activityCarSecondBinding.apply {
            q3Button.setOnClickListener {
                q3Factory.also {
                    it.createTire().tire()
                    it.createEngine().engine()
                    it.createBrake().brake()
                }
            }
            q7Button.setOnClickListener {
                q7Factory.also {
                    it.createTire().tire()
                    it.createEngine().engine()
                    it.createBrake().brake()
                }
            }
        }
    }
}