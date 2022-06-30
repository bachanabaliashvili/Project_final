package com.example.myapplication.activities

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.example.myapplication.R

object NotificationUtil {

    const val CHANNEL_ID = "MYCHANNEL"

    fun showSimpleNotification(context: Context, text: String) {

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_airplanemode_active_24)
            .setContentTitle("air plane mode")
            .setContentText(text)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(1, notification.build())
    }
}