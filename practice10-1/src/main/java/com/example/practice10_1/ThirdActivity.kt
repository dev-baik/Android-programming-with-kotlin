package com.example.practice10_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practice10_1.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private val binding by lazy { ActivityThirdBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnReturn.setOnClickListener {
            finish()
        }
    }
}