package com.example.practice6_1

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.practice6_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var selectYear = 0
    var selectMonth = 0
    var selectDay = 0
    var selectHour = 0
    var selectMinute = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            rdoG.visibility = View.INVISIBLE
            datePicker.visibility = View.INVISIBLE
            timePicker.visibility = View.INVISIBLE

            rdoCal.setOnClickListener {
                datePicker.visibility = View.VISIBLE
            }

            rdoTime.setOnClickListener {
                timePicker.visibility = View.VISIBLE
            }

            datePicker.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
                selectYear = year
                selectMonth = monthOfYear + 1
                selectDay = dayOfMonth
            }

            chronometer1.setOnClickListener {
                rdoG.visibility = View.VISIBLE
                chronometer1.base = SystemClock.elapsedRealtime()
                chronometer1.start()
                chronometer1.setTextColor(Color.RED)
            }

            btnEnd.setOnLongClickListener {
                chronometer1.stop()
                chronometer1.setTextColor(Color.RED)

                selectHour = timePicker.hour
                selectMinute = timePicker.minute
                btnEnd.text = "${selectYear}년${selectMonth}월${selectDay}일${selectHour}시${selectMinute}분 예약됨"

                rdoG.visibility = View.INVISIBLE
                datePicker.visibility = View.INVISIBLE
                timePicker.visibility = View.INVISIBLE

                false
            }
        }
    }
}