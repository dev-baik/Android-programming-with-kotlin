package com.example.practice6_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice6_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            binding.viewFlipper.startFlipping()
            binding.viewFlipper.flipInterval = 1000
        }

        binding.btnStop.setOnClickListener {
            binding.viewFlipper.stopFlipping()
        }
    }
}