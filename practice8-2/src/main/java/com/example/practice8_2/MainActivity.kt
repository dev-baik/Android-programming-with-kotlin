package com.example.practice8_2

import android.content.Context
import android.os.Build.VERSION_CODES.N
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import androidx.core.app.ActivityCompat
import com.example.practice8_2.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), Context.MODE_PRIVATE)
        var imageFiles = File(Environment.getExternalStorageDirectory().absolutePath + "/Pictures").listFiles()
        var imageName = imageFiles!![0].toString()
        binding.myPictureView.imagePath = imageName

        var curNum = 0
        binding.tvNumber.text = "1/${imageFiles.size}"

        binding.btnPrev.setOnClickListener {
            if(curNum <= 0){
                curNum = imageFiles!!.size -1
            }else{
                curNum--
            }
            binding.tvNumber.text = "${curNum+1}/${imageFiles.size}"
            imageName = imageFiles[curNum].toString()
            binding.myPictureView.imagePath = imageName
            binding.myPictureView.invalidate()
        }

        binding.btnNext.setOnClickListener {
            if(curNum >= 4){
                curNum = imageFiles!!.size - 3
            }else{
                curNum++
            }
            binding.tvNumber.text = "${curNum}/${imageFiles.size}"
            imageName = imageFiles[curNum-1].toString()
            binding.myPictureView.imagePath = imageName
            binding.myPictureView.invalidate()
        }
    }
}