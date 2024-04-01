package dev.nermingules.notificationbroadcast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.nermingules.notificationbroadcast.databinding.ActivityNotificationBinding

class ActivityNotification : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.tvDeger.text = intent.getStringExtra("deger")
    }
}