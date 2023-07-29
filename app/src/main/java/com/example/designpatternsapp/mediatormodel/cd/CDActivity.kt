package com.example.designpatternsapp.mediatormodel.cd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.designpatternsapp.databinding.ActivityCdBinding

class CDActivity: AppCompatActivity() {

    private lateinit var activityCdBinding: ActivityCdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCdBinding = ActivityCdBinding.inflate(layoutInflater)
        setContentView(activityCdBinding.root)
        val mainBoard = MainBoard()
        val cdDevice = CDDevice(mainBoard)
        mainBoard.let {
            it.cdDevice = cdDevice
        }

        activityCdBinding.cdButton.setOnClickListener {
            cdDevice.load()
        }
    }
}