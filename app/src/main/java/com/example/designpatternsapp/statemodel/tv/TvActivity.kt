package com.example.designpatternsapp.statemodel.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.databinding.ActivityTvBinding

class TvActivity : AppCompatActivity() {
    private lateinit var activityTvBinding: ActivityTvBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityTvBinding = ActivityTvBinding.inflate(layoutInflater)
        setContentView(activityTvBinding.root)
        val tvController = TvController()
        activityTvBinding.apply {
            powerOnButton.setOnClickListener {
                tvController.powerOn()
            }
            powerOffButton.setOnClickListener {
                tvController.powerOff()
            }
            nextChannelButton.setOnClickListener {
                tvController.nextChannel()
            }
            prevChannelButton.setOnClickListener {
                tvController.prevChannel()
            }
            turnUpButton.setOnClickListener {
                tvController.turnUp()
            }
            turnDownButton.setOnClickListener {
                tvController.turnDown()
            }
        }
    }
}