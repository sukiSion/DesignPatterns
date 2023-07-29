package com.example.designpatternsapp.buildermodel.build

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityBuildBinding

class BuildActivity : AppCompatActivity() {
    private lateinit var activityBuildBinding: ActivityBuildBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBuildBinding = ActivityBuildBinding.inflate(layoutInflater)
        setContentView(activityBuildBinding.root)
        val builder = MacBookBuilder(MacBook())
        Director(builder).construct("A系列主板" , "Retina显示器")
        activityBuildBinding.makeMacbookButton.setOnClickListener {
            Log.e("MacBook" , builder.create().toString())

        }
    }
}