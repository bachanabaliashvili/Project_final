package com.example.myapplication.activities

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings

private const val TAG = "MyBroadcastReceiver"

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val enabledAirPlan : Boolean =
            Settings.Global.getInt(context?.contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0) != 0

        if (context != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val imp = NotificationManager.IMPORTANCE_DEFAULT

                val channel = NotificationChannel(NotificationUtil.CHANNEL_ID, NotificationUtil.CHANNEL_ID, imp).apply {
                    description = TAG
                }

                val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }

            if (enabledAirPlan) {
                NotificationUtil.showSimpleNotification(context, "enabled")
            } else {
                NotificationUtil.showSimpleNotification(context, "disabled")
            }
        }

    }
}