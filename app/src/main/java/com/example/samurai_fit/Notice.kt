package com.example.samurai_fit

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class Notice {
    fun sendNotification(context: Context) {
        val channelId = "com.example.sample_notification"
        val channelName = "my channel"
        val channelDescription = "This is a sample notification."

        //Android 8.0 以上ではアプリの通知チャンネルを登録することが必要。
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { //---*0
            val importance = NotificationManager.IMPORTANCE_DEFAULT //---*1
            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = channelDescription
            }
            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }

        val intent = Intent(context,MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        //通知をシステムに登録しています。
        val builder = NotificationCompat.Builder(context, channelId).apply {
            setSmallIcon(R.drawable.ic_launcher_foreground) //---*2
            setContentTitle("通知のタイトル")
            setContentText("通知するメッセージ")
            setContentIntent(pendingIntent)
            setAutoCancel(true)
            priority = NotificationCompat.PRIORITY_DEFAULT //---*3
        }
        val id = 0 //---*4
        NotificationManagerCompat.from(context).notify(id, builder.build())

    }
}