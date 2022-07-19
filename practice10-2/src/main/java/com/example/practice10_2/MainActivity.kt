package com.example.practice10_2

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.practice10_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var imageArray: Array<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var voteCount = IntArray(9)
        for (i in 0..8) {
            voteCount[i] = 0
        }

        var imgName = arrayOf("사진1", "사진2", "사진3", "사진4", "사진5", "사진6", "사진7", "사진8", "사진9")

        with(binding) {
            imageArray = arrayOf(image1, image2, image3, image4, image5, image6, image7, image8, image9)

            for(i in 0..8) {
                imageArray[i].setOnClickListener {
                    voteCount[i]++
                    Toast.makeText(applicationContext, "${imgName[i]} : 총 ${voteCount[i]}", Toast.LENGTH_SHORT).show()
                }
            }

            btnResult.setOnClickListener {
                var intent = Intent(applicationContext, ResultActivity::class.java)
                intent.putExtra("VoteCount", voteCount)
                intent.putExtra("ImageName", imgName)
                startActivity(intent)
            }
        }
    }
}