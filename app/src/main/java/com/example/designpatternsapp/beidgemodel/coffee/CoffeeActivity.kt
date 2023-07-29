package com.example.designpatternsapp.beidgemodel.coffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityCoffeeBinding

class CoffeeActivity : AppCompatActivity() {
    private lateinit var activityCoffeeBinding: ActivityCoffeeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCoffeeBinding = ActivityCoffeeBinding.inflate(layoutInflater)
        setContentView(activityCoffeeBinding.root)
        activityCoffeeBinding.apply {
            largeOrdinary.setOnClickListener {
                LargrCoffee(Ordinary()).makeCoffee()
            }
            largeSugar.setOnClickListener {
                LargrCoffee(Sugar()).makeCoffee()
            }
            smallOrdinary.setOnClickListener {
                SmallCoffee(Ordinary()).makeCoffee()
            }
            smallSugar.setOnClickListener {
                SmallCoffee(Sugar()).makeCoffee()
            }
            middleOrdinary.setOnClickListener {
                MiddleCoffee(Ordinary()).makeCoffee()
            }
            middleSugar.setOnClickListener {
                MiddleCoffee(Sugar()).makeCoffee()
            }
        }
    }
}