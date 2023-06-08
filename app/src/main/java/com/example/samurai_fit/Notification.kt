package com.example.samurai_fit

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class Notification : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            // 通知を送信するタイミングで呼び出す
            createNotificationChannel()
            showNotification()
        }
    }

    // 通知チャンネルを作成する関数
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "channel_id" // 通知チャンネルのID
            val channelName = "Channel Name" // 通知チャンネルの名前
            val channelDescription = "Channel Description" // 通知チャンネルの説明
            val importance = NotificationManager.IMPORTANCE_DEFAULT // 通知の重要度

            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = channelDescription
            }

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
    // 通知を作成して表示する関数
    private fun showNotification() {
        val channelId = "channel_id" // 作成した通知チャンネルのID
        val notificationId = 1 // 通知の識別子

        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(androidx.core.R.drawable.notification_bg_normal)
            .setContentTitle("Notification Title") // 通知のタイトル
            .setContentText("Notification Text") // 通知のテキスト
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) // 通知の優先度
            .setAutoCancel(true) // 通知をタップした時に自動的に閉じる

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(notificationId, notificationBuilder.build())
    }

}