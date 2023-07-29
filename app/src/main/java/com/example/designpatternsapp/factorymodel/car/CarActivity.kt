package com.example.designpatternsapp.factorymodel.car

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityCarBinding

class CarActivity : AppCompatActivity() {
    private lateinit var activityCarBinding: ActivityCarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCarBinding = ActivityCarBinding.inflate(layoutInflater)
        setContentView(activityCarBinding.root)
        val audiCarFactory = AudiCarFactory()
        activityCarBinding.apply {
            q3Button.setOnClickListener {
                audiCarFactory.createAudiCar(
                    AudiQ3::class.java
                )?.apply {
                    drive()
                    selfNavigation()
                }
            }
            q5Button.setOnClickListener {
                audiCarFactory.createAudiCar(
                    AudiQ5::class.java
                )?.apply {
                    drive()
                    selfNavigation()
                }
            }
            q7Button.setOnClickListener {
                audiCarFactory.createAudiCar(
                    AudiQ7::class.java
                )?.apply {
                    drive()
                    selfNavigation()
                }
            }
        }
    }
}