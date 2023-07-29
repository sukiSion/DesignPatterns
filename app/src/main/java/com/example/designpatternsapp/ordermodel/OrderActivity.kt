package com.example.designpatternsapp.ordermodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {
    private lateinit var activityOrderBinding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityOrderBinding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(activityOrderBinding.root)
        val tetrisMachine = TetrisMachine()
        val invoker = Invoke(
            leftCommand = LeftCommand(tetrisMachine),
            rightCommand = RightCommand(tetrisMachine),
            fallCommand = FallCommand(tetrisMachine),
            transformCommand = TransformCommand(tetrisMachine)
        )

        activityOrderBinding.apply {
            leftButton.setOnClickListener {
                invoker.toLeft()
            }
            transformButton.setOnClickListener {
                invoker.transform()
            }
            fallButton.setOnClickListener {
                invoker.fall()
            }
            rigthButton.setOnClickListener {
                invoker.toRight()
            }
        }
    }
}