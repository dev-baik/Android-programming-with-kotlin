package com.example.practice10_3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practice10_3.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var calc = intent.getStringExtra("Calc")
        var hapValue : Int? = 0

        when (calc) {
            "+" -> hapValue = intent.getIntExtra("Num1", 0) + intent.getIntExtra("Num2", 0)
            "-" -> hapValue = intent.getIntExtra("Num1", 0) - intent.getIntExtra("Num2", 0)
            "*" -> hapValue = intent.getIntExtra("Num1", 0) * intent.getIntExtra("Num2", 0)
            "/" -> hapValue = intent.getIntExtra("Num1", 0) / intent.getIntExtra("Num2", 0)
        }

        binding.btnReturn.setOnClickListener{
            var outIntent = Intent(applicationContext, MainActivity::class.java)
            outIntent.putExtra("Hap", hapValue)
            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }
    }
}
