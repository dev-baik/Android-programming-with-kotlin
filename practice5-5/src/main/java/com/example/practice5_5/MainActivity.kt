package com.example.practice5_5

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practice5_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var numBtn: Array<Button>
    private var num1 = ""
    private var num2 = ""
    private var total = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            numBtn = arrayOf(btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)

            for (i in 0..9 step 1) {
                numBtn[i].setOnClickListener {
                    if(edit1.isFocused) {
                        num1 = edit1.text.toString() + numBtn[i].text.toString()
                        edit1.setText(num1)
                    }
                    else if(edit2.isFocused) {
                        num2 = edit2.text.toString() + numBtn[i].text.toString()
                        edit2.setText(num2)
                    }
                    else {
                        Toast.makeText(applicationContext, "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            btnAdd.setOnClickListener {
                total = Integer.parseInt(edit1.text.toString()) + Integer.parseInt(edit2.text.toString())
                text1.text = "계산 결과 : $total"
            }

            btnSub.setOnClickListener {
                total = Integer.parseInt(edit1.text.toString()) - Integer.parseInt(edit2.text.toString())
                text1.text = "계산 결과 : $total"
            }

            btnMul.setOnClickListener {
                total = Integer.parseInt(edit1.text.toString()) * Integer.parseInt(edit2.text.toString())
                text1.text = "계산 결과 : $total"
            }

            btnDiv.setOnClickListener {
                total = Integer.parseInt(edit1.text.toString()) / Integer.parseInt(edit2.text.toString())
                text1.text = "계산 결과 : $total"
            }
        }
    }
}