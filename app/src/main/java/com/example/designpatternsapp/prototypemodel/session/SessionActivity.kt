package com.example.designpatternsapp.prototypemodel.session

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivitySessionBinding

class SessionActivity : AppCompatActivity() {
    private lateinit var activitySessionBinding: ActivitySessionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySessionBinding = ActivitySessionBinding.inflate(layoutInflater)
        setContentView(activitySessionBinding.root)
        val session = LoginSession.instance
        activitySessionBinding.apply {
            getUserButton.setOnClickListener {
                Log.e("session" , "${session.getLoginedUser()}")
            }
            updateUserButton.setOnClickListener {
                LoginImpl().update()
            }
            loginButton.setOnClickListener {
                LoginImpl().login()
            }
        }
    }
}