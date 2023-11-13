// NotificationAdapter.kt
package com.example.tuuti4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.tuuti4.R

class NotificationAdapter(context: Context, resource: Int, notifications: List<Notification>) :
    ArrayAdapter<Notification>(context, resource, notifications) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val notification = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.notification_list_item, parent, false)

        val titleTextView = view.findViewById<TextView>(R.id.notificationTitle)
        val contentTextView = view.findViewById<TextView>(R.id.notificationContent)

        titleTextView.text = notification?.title
        contentTextView.text = notification?.content

        return view
    }
}
//NotificationAdapter クラスは NotificationListActivity 内で使用され、通知データをリストビューに表示するためのアダプタークラスとなります。このアダプターは、各通知のデータを取り込んでリストビューに表示する
