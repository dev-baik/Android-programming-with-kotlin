package com.example.exercise4_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercise4_9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            binding.imgView.rotation += 10F
        }
    }
}