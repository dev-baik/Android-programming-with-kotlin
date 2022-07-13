package com.example.practice4_3

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practice4_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var num1: String
    private lateinit var num2: String
    private var result: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            num1 = binding.edt1.text.toString()
            num2 = binding.edt2.text.toString()

            // 값을 입력하지 않고 버튼을 클릭할 때 오류 메시지를 토스트 메시지로 나타낸다.
            if(num1.trim() == "" || num2.trim() == "") {
                Toast.makeText(applicationContext, "값을 입력하세요", Toast.LENGTH_SHORT).show()
            }
            else {
                result = Integer.parseInt(num1) + Integer.parseInt(num2)
                binding.textResult.text = result.toString()
            }
        }

        binding.btnSub.setOnClickListener {
            num1 = binding.edt1.text.toString()
            num2 = binding.edt2.text.toString()

            if(num1.trim() == "" || num2.trim() == "") {
                Toast.makeText(applicationContext, "값을 입력하세요", Toast.LENGTH_SHORT).show()
            }
            else {
                result = Integer.parseInt(num1) - Integer.parseInt(num2)
                binding.textResult.text = "계산결과 : ${result.toString()}"
            }
        }

        binding.btnMul.setOnClickListener {
            num1 = binding.edt1.text.toString()
            num2 = binding.edt2.text.toString()

            var result: Float?
            result = num1.toFloat() * num2.toFloat()
            binding.textResult.text = "계산결과 : " + String.format("%.2f", result)
        }

        binding.btnDiv.setOnClickListener {
            num1 = binding.edt1.text.toString()
            num2 = binding.edt2.text.toString()

            var result: Float?
            if (num2 == "0") {
                Toast.makeText(applicationContext, "0으로 나눌수 없습니다.", Toast.LENGTH_SHORT).show()
            }
            else {
                result = num1.toFloat() / num2.toFloat()
                binding.textResult.text = "계산결과 : " + String.format("%.2f", result)
            }
        }

        binding.btnRemain.setOnClickListener {
            num1 = binding.edt1.text.toString()
            num2 = binding.edt2.text.toString()

            var result: Float?
            result = num1.toFloat() % num2.toFloat()
            binding.textResult.text = "계산결과 : " + String.format("%.2f", result)
        }
    }
}