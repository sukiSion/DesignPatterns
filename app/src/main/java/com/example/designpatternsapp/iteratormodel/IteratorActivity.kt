package com.example.designpatternsapp.iteratormodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityIteratorBinding

class IteratorActivity : AppCompatActivity() {
    private lateinit var activityIteratorBinding: ActivityIteratorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityIteratorBinding = ActivityIteratorBinding.inflate(layoutInflater)
        setContentView(activityIteratorBinding.root)
        activityIteratorBinding.checkButton.setOnClickListener {
            val companyMin = CompanyMin()
            val companyHui = CompanyHui()
            companyMin.iterator().check {
                Log.e("${IteratorActivity::class.java.simpleName}" , "${it}")
            }
            companyHui.iterator().check {
                Log.e("${IteratorActivity::class.java.simpleName}" , "${it}")
            }
        }
    }
}