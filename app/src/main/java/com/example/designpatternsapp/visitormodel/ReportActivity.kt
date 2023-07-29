package com.example.designpatternsapp.visitormodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityReportBinding

class ReportActivity : AppCompatActivity() {
    private lateinit var activityReportBinding: ActivityReportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityReportBinding = ActivityReportBinding.inflate(layoutInflater)
        setContentView(activityReportBinding.root)
        val businessReport = BusinessReport()
        activityReportBinding.apply {
            ceoButton.setOnClickListener {
                businessReport.showReport(
                    CEOVisitor()
                )
            }
            ctoButton.setOnClickListener {
                businessReport.showReport(
                    CTOVisitor()
                )
            }
        }
    }
}