package com.example.practice10_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice10_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnNewActivity.setOnClickListener{
            var intent1 : Intent
            if (binding.rdo2.isChecked) {
                intent1 = Intent(applicationContext, SecondActivity::class.java)
            } else {
                intent1 = Intent(applicationContext, ThirdActivity::class.java)
            }
            this.startActivity(intent1)
        }
    }
}