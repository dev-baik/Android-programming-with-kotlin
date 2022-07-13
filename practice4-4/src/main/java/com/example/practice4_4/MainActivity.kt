package com.example.practice4_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.practice4_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            chkAgree.setOnCheckedChangeListener { buttonView, isChecked ->
                if (chkAgree.isChecked) {
                    text.visibility = View.VISIBLE
                    rGroup.visibility = View.VISIBLE
                    imgAndroid.visibility = View.VISIBLE
                    btnEnd.visibility = View.VISIBLE
                    btnBegin.visibility = View.VISIBLE
                } else {
                    text.visibility = View.INVISIBLE
                    rGroup.visibility = View.INVISIBLE
                    imgAndroid.visibility = View.INVISIBLE
                    btnEnd.visibility = View.INVISIBLE
                    btnBegin.visibility = View.INVISIBLE
                }
            }

            rGroup.setOnCheckedChangeListener { buttonView, isChecked ->
                when (rGroup.checkedRadioButtonId) {
                    R.id.rdoOreo -> imgAndroid.setImageResource(R.drawable.oreo)
                    R.id.rdoPie -> imgAndroid.setImageResource(R.drawable.pie)
                    R.id.rdoQ -> imgAndroid.setImageResource(R.drawable.q)
                    else -> Toast.makeText(applicationContext, "먼저 선택하세요", Toast.LENGTH_SHORT).show()
                }
            }

            btnEnd.setOnClickListener {
                finish()
            }

            btnBegin.setOnClickListener {
                chkAgree.isChecked = false
            }
        }
    }
}