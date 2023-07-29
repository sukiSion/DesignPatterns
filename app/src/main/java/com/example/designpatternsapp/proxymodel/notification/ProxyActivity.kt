package com.example.designpatternsapp.proxymodel.notification

import android.Manifest
import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RemoteViews
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityNotificationBinding
import com.example.designpatternsapp.databinding.ActivityProxyBinding

class ProxyActivity : AppCompatActivity() {
    private lateinit var activityProxyBinding: ActivityProxyBinding

    private val notificationManager  by lazy {
        getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    }


    private val notificationBuilder: NotificationCompat.Builder  by lazy {
        NotificationCompat.Builder(this , "Sion")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContent(RemoteViews(
                packageName,
                R.layout.notification_view
            ))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(
                PendingIntent.getActivity(
                    this,
                    0,
                    Intent(this, NotificationActivity::class.java),
                    PendingIntent.FLAG_IMMUTABLE
                )
            )
            .setAutoCancel(true)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityProxyBinding = ActivityProxyBinding.inflate(layoutInflater)
        setContentView(activityProxyBinding.root)
        val proxy = NotifyProxy(this , NotifyType.HeadsUp)
        activityProxyBinding.sendNotificationButton.setOnClickListener {
            proxy.send()
        }
        activityProxyBinding.cancelNotificationButton.setOnClickListener {
            proxy.cancel()
        }
    }
}