package com.example.samurai_fit

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, p1: Intent?) {
        if(context != null) {
            val notification = Notice()
            notification.sendNotification(context)
        }
    }
}