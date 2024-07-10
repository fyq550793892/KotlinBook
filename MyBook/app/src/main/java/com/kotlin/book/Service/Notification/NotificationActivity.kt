package com.kotlin.book.Service.Notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_MUTABLE
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.kotlin.book.R
import com.kotlin.book.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "channel",
                "MySeeChannel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            manager.createNotificationChannel(channel)
        }



        binding.btSendNotification.setOnClickListener {
            val pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                PendingIntent.getActivity(this,0,Intent(this,NotificationOther::class.java,),PendingIntent.FLAG_MUTABLE)
            } else {
                TODO("VERSION.SDK_INT < S")
            }
            val notification = NotificationCompat.Builder(this, "channel").setContentTitle("我是标题")
                .setContentText("这是文本").setSmallIcon(R.drawable.ic_launcher_foreground)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        resources,
                        R.drawable.ic_launcher_foreground
                    )
                ).setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()
            manager.notify(1,notification)
        }


//        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        val channel =  NotificationChannel("channel","MyChannel",NotificationManager.IMPORTANCE_DEFAULT)
//        binding.btSendNotification.setOnClickListener {
//            val notification = NotificationCompat.Builder(this,"channel").build()
//            manager.notify(1,notification)
//        }

    }
}