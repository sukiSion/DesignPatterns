package com.example.designpatternsapp.templatemodel.computer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityComputerBinding

class ComputerActivity : AppCompatActivity() {
    private lateinit var activityComputerBinding: ActivityComputerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComputerBinding = ActivityComputerBinding.inflate(layoutInflater)
        setContentView(activityComputerBinding.root)
        val coderComputer = CoderComputer()
        val militaryComputer = MilitaryComputer()

        activityComputerBinding.apply {
            openCoderComputerButton.setOnClickListener {
                coderComputer.startUp()
            }
            openMilitaryComputerButton.setOnClickListener {
                militaryComputer.startUp()
            }
        }
    }
}