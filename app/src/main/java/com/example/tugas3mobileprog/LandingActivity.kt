package com.example.tugas3mobileprog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas3mobileprog.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLandingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>("LOGGED_IN_USER")
        binding.tvWelcome.text = "Welcome, ${user?.username}!"
    }
}