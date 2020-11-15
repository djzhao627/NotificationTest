package cn.djzhao.notificationtest

import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nitification)

        // 手动关闭通知
        (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).cancel(1)
    }
}