package dev.nermingules.notificationbroadcast

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import dev.nermingules.notificationbroadcast.databinding.ActivityMainBinding
import dev.nermingules.notificationbroadcast.databinding.ActivityNotificationBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener(){
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
                val channel = NotificationChannel(packageName,"Kanal Adı",NotificationManager.IMPORTANCE_DEFAULT).apply {}
                notificationManager.createNotificationChannel(channel)
            }

            val builder = NotificationCompat.Builder(this,packageName)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Bildirim Başlığı")
                .setContentText("Bildirim içeriği")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            val notificationIntent = Intent(this,ActivityNotification::class.java)
            notificationIntent.putExtra("deger","Gönderilen değer")

            val pendingIntent = PendingIntent.getActivity(
                this,
                0,
                notificationIntent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )
            builder.setContentIntent(pendingIntent)

            notificationManager.notify(0,builder.build())
        }
    }

}