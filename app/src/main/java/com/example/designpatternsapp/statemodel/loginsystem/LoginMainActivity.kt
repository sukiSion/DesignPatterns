package com.example.designpatternsapp.statemodel.loginsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityLoginMainBinding

class LoginMainActivity : AppCompatActivity() {
    private lateinit var activityLoginMainBinding: ActivityLoginMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginMainBinding = ActivityLoginMainBinding.inflate(layoutInflater)
        setContentView(activityLoginMainBinding.root)
        activityLoginMainBinding.also {
            it.forwardButton.setOnClickListener {
                LoginContext.instance.forward(this)
            }
            it.commentButton.setOnClickListener {
                LoginContext.instance.comment(this)
            }
            it.logoutButton.setOnClickListener {
                LoginContext.instance.logout()
            }

        }
    }
}