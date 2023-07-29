package com.example.designpatternsapp.proxymodel.notification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.designpatternsapp.databinding.ActivityNotificationBinding

class NotificationActivity: AppCompatActivity() {

    private lateinit var activityNotificationBinding: ActivityNotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityNotificationBinding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(activityNotificationBinding.root)
    }
}