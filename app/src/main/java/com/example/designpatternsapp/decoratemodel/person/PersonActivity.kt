package com.example.designpatternsapp.decoratemodel.person

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityPersonBinding

class PersonActivity : AppCompatActivity() {
    private lateinit var activityPersonBinding: ActivityPersonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPersonBinding = ActivityPersonBinding.inflate(layoutInflater)
        setContentView(activityPersonBinding.root)
        val person = Boy()
        activityPersonBinding.apply {
            putOnCheapButton.setOnClickListener {
                CheapCloth(person).dressed()
            }
            putOnExpensiveButton.setOnClickListener {
                ExpensiveCloth(person).dressed()
            }
        }
    }
}