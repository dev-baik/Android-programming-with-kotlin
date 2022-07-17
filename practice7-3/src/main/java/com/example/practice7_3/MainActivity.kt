package com.example.practice7_3

import android.app.AlertDialog
import android.os.Bundle
import android.view.Display
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practice7_3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            var dialogView = View.inflate(this, R.layout.dialog1, null)
            var dlg = AlertDialog.Builder(this)
            dlg.setView(dialogView)
            dlg.setPositiveButton("확인") { dialog, which ->
                Toast.makeText(applicationContext, "완료했습니다", Toast.LENGTH_LONG).show()
                var view = dialogView.findViewById<EditText>(R.id.dlgEdt1)
                binding.text1.setText(view.text.toString())
                var view2 = dialogView.findViewById<EditText>(R.id.dlgEdt2)
                binding.text2.setText(view2.text.toString())
            }

            dlg.setNegativeButton("취소") { dialog, which ->
                var toast = Toast(this)
                var toastView = View.inflate(this, R.layout.toast1, null)
                toastView.findViewById<TextView>(R.id.toastText).text = "취소했습니다."
                toast.view = toastView

                val display: Display = (getSystemService(WINDOW_SERVICE) as WindowManager).defaultDisplay
                val xoffset = (Math.random() * display.getWidth()).toInt()
                val yoffset = (Math.random() * display.getHeight()).toInt()
                toast.setGravity(Gravity.TOP or Gravity.LEFT, xoffset, yoffset)
                toast.show()
            }
            dlg.show()
        }
    }
}