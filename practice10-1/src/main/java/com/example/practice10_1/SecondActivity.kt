package com.example.practice10_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice10_1.databinding.ActivityMainBinding
import com.example.practice10_1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnReturn.setOnClickListener {
            finish()
        }
    }
}