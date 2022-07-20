package com.example.practice11_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.practice11_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var movie : Array<String> = arrayOf("쿵푸팬더", "짱구는 못말려", "아저씨", "아바타")
        var posterID =arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4)

        var sAdapter1 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, movie)
        binding.spinner1.adapter = sAdapter1

        binding.spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "아무것도 선택하지 않음, 선택하세요...", Toast.LENGTH_SHORT).show()
            }

            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.ivPoster.setImageResource(posterID[position])
            }
        }
    }
}