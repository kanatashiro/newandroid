package com.example.tuuti4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getFirebaseToken()

        NotificationUtils.createNotificationChannel(
            this,
            "your_channel_id",
            "Your Channel Name")

    }

    private fun getFirebaseToken() {
        FirebaseMessaging.getInstance().token
            .addOnSuccessListener { token ->
                // デバイストークンをログに表示（開発中に確認するため）
                Log.d("Firebase Token", token)
            }
            .addOnFailureListener { exception ->
                // トークンの取得に失敗した場合の処理
                Log.e("Firebase Token", "Token retrieval failed: $exception")
            }
    }


    fun openNotificationScreen(view: View?) {
        val intent = Intent(this, NotificationListActivity::class.java)
        startActivity(intent)
    }

}