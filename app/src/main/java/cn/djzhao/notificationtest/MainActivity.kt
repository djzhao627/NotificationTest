package cn.djzhao.notificationtest

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel("normal", "normal", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(notificationChannel)
            val notificationChannel2 = NotificationChannel("important", "important", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel2)
        }

        sendNotice.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
            // val notification = NotificationCompat.Builder(this, "normal")
            // 使用另一个通知渠道
            val notification = NotificationCompat.Builder(this, "important")
                    .setContentTitle("学习使用通知")
                    // 文本显示不全
                    // .setContentText("学习怎么构建通知，怎么发送和同步数据，并且使用语音操作。\n使用Android官方开发工具来构建多媒体APP。")
                    // 显示多行文本
                    .setStyle(NotificationCompat.BigTextStyle().bigText("学习怎么构建通知，怎么发送和同步数据，并且使用语音操作。\n使用Android官方开发工具来构建多媒体APP。"))
                    // 展示图片(与文字二选一)
                    .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources, R.drawable.big_image)))
                    .setSmallIcon(R.drawable.small_icon)
                    .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.large_icon))
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .build()
            notificationManager.notify(1, notification)
        }
    }
}