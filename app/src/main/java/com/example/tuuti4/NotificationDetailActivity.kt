package com.example.tuuti4

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// NotificationDetailActivity.kt
class NotificationDetailActivity : AppCompatActivity() {
    // 通知の詳細情報を表示するためのコードを含めます

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_detail)

        val notification = intent.getSerializableExtra("notification") as Notification
        val titleTextView = findViewById<TextView>(R.id.detailTitle)
        val contentTextView = findViewById<TextView>(R.id.detailContent)

        titleTextView.text = notification.title
        contentTextView.text = notification.content
    }
}
