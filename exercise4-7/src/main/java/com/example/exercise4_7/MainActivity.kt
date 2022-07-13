package com.example.exercise4_7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exercise4_7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            chk1.setOnCheckedChangeListener { compoundButton, b->
                btn1.isEnabled= !btn1.isEnabled
            }
            chk2.setOnCheckedChangeListener { compoundButton, b->
                btn1.isClickable= !btn1.isClickable
            }
            chk3.setOnCheckedChangeListener { compoundButton, b->
                if(chk3.isChecked) {
                    btn1.rotation = 45F
                }
                if(!chk3.isChecked) {
                    btn1.rotation = 0F
                }
            }
        }
    }
}