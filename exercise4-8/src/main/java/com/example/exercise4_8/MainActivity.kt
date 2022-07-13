package com.example.exercise4_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.exercise4_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.edt1.setOnKeyListener { v, keyCode, event ->
        var str = binding.edt1.text.toString()
            Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()
            false
        }
    }
}