package com.example.tuuti4

import java.io.Serializable

// Notification.kt
//通知データを保持するデータ構造を作成します。通知の情報を格納するクラス
data class Notification(val title: String, val content: String, val timestamp: Long) : Serializable
