package com.example.designpatternsapp.strategymodel.goout

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityGoOutBinding

class GoOutActivity : AppCompatActivity() {

    private lateinit var activityGoOutBinding: ActivityGoOutBinding
    private val km = 16

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityGoOutBinding = ActivityGoOutBinding.inflate(layoutInflater)
        setContentView(activityGoOutBinding.root)
        activityGoOutBinding.apply {
            calculateBusButton.setOnClickListener {
                price.text = "${TranficCalCulator(BusStrategy()).calcuatePrice(km)}"
            }
            calculateSubwayButton.setOnClickListener {
                price.text = "${TranficCalCulator(SubwayStrategy()).calcuatePrice(km)}"
            }
            calculateTaxiButton.setOnClickListener {
                price.text = "${TranficCalCulator(TaxiStrategy()).calcuatePrice(16)}"
            }
        }
    }


}