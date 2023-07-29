package com.example.designpatternsapp.proxymodel.notification

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.designpatternsapp.R
import java.lang.StringBuilder

enum class NotifyType{
    NORMAL,
    BIG,
    HeadsUp
}

class NotifyProxy (
    private val context: Context,
    private val notifyType: NotifyType = NotifyType.NORMAL
): Notify(context){

    private val notify:Notify by lazy {
        when(notifyType){
            NotifyType.NORMAL -> {
                NormalNotify(context)
            }
            NotifyType.BIG -> {
                BigNotify(context)
            }
            NotifyType.HeadsUp -> {
                HeadsUpNotify(context)
            }
        }
    }

    override fun send() {
        notify.send()
    }

    override fun cancel() {
        notify.cancel()
    }

    override fun reformNotification(notificationCompatBuilder: NotificationCompat.Builder) {
        notify.reformNotification(notificationCompatBuilder)
    }
}

abstract class Notify(
    private val context: Context
){

    companion object{
        val channelId = Notify::class.java.simpleName
        val messageId = 114514
    }

    private val notificationManager:NotificationManager

    init {
        // 版本8以上需要创建通知渠道
        notificationManager = context.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            notificationManager.createNotificationChannel(
                NotificationChannel(
                    channelId,
                    "proxy",
                    NotificationManager.IMPORTANCE_HIGH
                )
            )
        }
    }

    private val notificationManagerCompat by lazy {
        NotificationManagerCompat.from(context)
    }

    private val notificationCompatBuilder by lazy {
        NotificationCompat.Builder(context , channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setFullScreenIntent(
                PendingIntent.getActivity(
                    context,
                    0,
                    Intent(
                        context,
                        NotificationActivity::class.java
                    ),
                    PendingIntent.FLAG_UPDATE_CURRENT
                ),
                true
            )
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
    }

    abstract fun reformNotification(notificationCompatBuilder: NotificationCompat.Builder)

    open fun send(){
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            reformNotification(notificationCompatBuilder)
            notificationManagerCompat.notify(
                messageId,
                notificationCompatBuilder.build()
            )
        }
    }

    open fun cancel(){
        notificationManagerCompat.cancel(
            messageId
        )
    }
}

class NormalNotify(private val context: Context): Notify(context){

    override fun reformNotification(notificationCompatBuilder: NotificationCompat.Builder) {
        notificationCompatBuilder.setCustomContentView(
            RemoteViews(
                context.packageName,
                R.layout.notification_view
            )
        )
    }


}



class BigNotify(private val context: Context) : Notify(context){

    override fun reformNotification(notificationCompatBuilder: NotificationCompat.Builder) {
        notificationCompatBuilder.setCustomBigContentView(
            RemoteViews(
                context.packageName,
                R.layout.notification_view
            )
        )
    }
}

class HeadsUpNotify(private val context: Context) : Notify(context){

    override fun reformNotification(notificationCompatBuilder: NotificationCompat.Builder) {
        notificationCompatBuilder
            .setCustomHeadsUpContentView(
                RemoteViews(
                    context.packageName,
                    R.layout.notification_view
                )
            )
    }
}