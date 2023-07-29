package com.example.designpatternsapp.explainmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityExplainBinding

class ExplainActivity : AppCompatActivity() {
    private lateinit var activityExplainBinding: ActivityExplainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityExplainBinding = ActivityExplainBinding.inflate(layoutInflater)
        setContentView(activityExplainBinding.root)
        activityExplainBinding.explainButton.setOnClickListener {
            val te1 = TerminalExpression(4)
            val te2 = TerminalExpression(8)
            val te3 = TerminalExpression(2)
            val result = Calculator("9+1-6-7+6").calculate()
            Log.e(
                "${ExplainActivity::class.java.simpleName}",
                "${result}"
            )
        }
    }
}