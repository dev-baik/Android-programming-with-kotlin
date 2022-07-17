package com.example.exercise7_6

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import com.example.exercise7_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btn.setOnClickListener {
                var builder = AlertDialog.Builder(this@MainActivity)
                var dialogView = View.inflate(this@MainActivity, R.layout.dialog, null)
                builder.setView(dialogView)
                var dialog = builder.create()

                var digTextView = dialogView.findViewById<TextView>(R.id.dlgText)
                var digImageView = dialogView.findViewById<ImageView>(R.id.dlgImage)
                var btnClose = dialogView.findViewById<Button>(R.id.btnClose)

                when(rGroup.checkedRadioButtonId) {
                    R.id.rdoDog -> {
                        digTextView.text = "강아지"
                        digImageView.setImageResource(R.drawable.pic1)
                    }

                    R.id.rdoCat -> {
                        digTextView.text = "고양이"
                        digImageView.setImageResource(R.drawable.pic2)
                    }

                    R.id.rdoRabbit -> {
                        digTextView.text = "토끼"
                        digImageView.setImageResource(R.drawable.pic3)
                    }

                    else -> {
                        digTextView.text = "강아지"
                        digImageView.setImageResource(R.drawable.pic1)
                    }
                }
                dialog.show()

                btnClose.setOnClickListener {
                    dialog.dismiss()
                }
            }
        }
    }
}