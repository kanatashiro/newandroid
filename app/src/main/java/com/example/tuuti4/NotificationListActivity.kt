package com.example.tuuti4


import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


//通知一覧画面のアクティビティ。通知リストを表示し、クリック時に詳細画面に遷移するコード
class NotificationListActivity : AppCompatActivity() {
    // 通知データを表示するためのリストやアダプターの初期化などを含めます
    // ...
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_list)

        val notificationListView = findViewById<ListView>(R.id.notificationListView)
        val notifications = DummyData.notifications // 通知データのリスト

        val adapter = NotificationAdapter(this, R.layout.notification_list_item, notifications)
        notificationListView.adapter = adapter

        notificationListView.setOnItemClickListener { parent, view, position, id ->
            // クリックされた通知の詳細画面に遷移
            val clickedNotification = notifications[position]
            val intent = Intent(this, NotificationDetailActivity::class.java).apply {
                putExtra("notification", clickedNotification)
            }
            startActivity(intent)
        }
    }
}






