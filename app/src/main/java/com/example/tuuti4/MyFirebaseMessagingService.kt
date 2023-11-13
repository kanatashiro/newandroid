package com.example.tuuti4

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "From: ${remoteMessage.from}")

        // 通知のタイトルや本文を取得
        val title = remoteMessage.notification?.title
        val body = remoteMessage.notification?.body

        // 通知を表示
        title?.let { showNotification(it, body) }
    }

    private fun showNotification(title: String, body: String?) {
        val notificationBuilder = NotificationCompat.Builder(this, "your_channel_id")
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(R.drawable.ic_notification) // 通知アイコンのリソースを指定

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(1, notificationBuilder.build())
    }

    companion object {
        private const val TAG = "MyFirebaseMsgService"
    }
}
