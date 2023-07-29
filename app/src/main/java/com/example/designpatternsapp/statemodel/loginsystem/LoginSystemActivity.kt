package com.example.designpatternsapp.statemodel.loginsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityLoginSystemBinding

class LoginSystemActivity : AppCompatActivity() {
    private lateinit var activityLoginSystemBinding: ActivityLoginSystemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginSystemBinding = ActivityLoginSystemBinding.inflate(layoutInflater)
        setContentView(activityLoginSystemBinding.root)
        activityLoginSystemBinding.loginButton.setOnClickListener {
            LoginContext.instance.login()
            finish()
        }
    }
}