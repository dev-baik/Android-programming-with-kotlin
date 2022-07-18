package com.example.practice8_1

import android.content.Context
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.practice8_1.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var cal = Calendar.getInstance()
        var cYear = cal.get(Calendar.YEAR)
        var cMonth = cal.get(Calendar.MONTH)
        var cDay = cal.get(Calendar.DAY_OF_MONTH)
        var fileName = ""

        binding.datePicker1.init(cYear, cMonth, cDay) { datePicker, i, i2, i3 ->
            fileName = "" + i + "_" + (i2 + 1) + "_" + i3 + ".txt"
            var str = readDiary(fileName)
            binding.edtDiary.setText(str)
            binding.btnWrite.isEnabled = true
        }

        binding.btnWrite.setOnClickListener{
            var outFs = openFileOutput(fileName, Context.MODE_PRIVATE)
            var str = binding.edtDiary.text.toString()
            outFs.write(str.toByteArray())
            outFs.close()
            Toast.makeText(applicationContext, "$fileName 이 저장됨", Toast.LENGTH_LONG).show()
        }
    }

    fun readDiary(fileName: String) : String? {
        var diaryStr : String? = null
        try {
            var inFs = openFileInput(fileName)
            var txt = ByteArray(500)
            inFs.read(txt)
            inFs.close()
            diaryStr = txt.toString(Charsets.UTF_8)
            binding.btnWrite.text = "수정하기"
        } catch (e: IOException) {
            binding.edtDiary.hint = "읽기 없음"
            binding.btnWrite.text = "새로 저장"
        }
        return diaryStr
    }
}