package com.example.exercise2_7

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.exercise2_7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            var edt1 : String
            btn1.setOnClickListener {
                edt1 = edtUrl.text.toString()
                Toast.makeText(applicationContext, edt1, Toast.LENGTH_SHORT).show()
            }

            btn2.setOnClickListener {
                edt1 = edtUrl.text.toString()
                var mIntent = Intent(Intent.ACTION_VIEW, Uri.parse(edt1))
                startActivity(mIntent)
            }

            RdoG.setOnCheckedChangeListener{radioGroup, i->
                if (i == R.id.RdoOreo)
                    imageView1.setImageResource(R.drawable.pic1)
                else if (i == R.id.RdoPie)
                    imageView1.setImageResource(R.drawable.pic3)
            }
        }
    }
}