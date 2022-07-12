package com.example.practice2_3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice2_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnUri.setOnClickListener {
                var mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com"))
                startActivity(mIntent)
            }

            btnTel.setOnClickListener {
                var mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:/911"))
                startActivity(mIntent)
            }

            btnGallery.setOnClickListener {
                var mIntent =
                    Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"))
                startActivity(mIntent)
            }

            btnFinish.setOnClickListener {
                finish()
            }
        }
    }
}