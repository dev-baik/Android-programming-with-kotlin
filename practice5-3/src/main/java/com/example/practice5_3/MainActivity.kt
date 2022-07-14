package com.example.practice5_3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT)

        val baseLayout = LinearLayout(this)
        baseLayout.orientation= LinearLayout.VERTICAL
        setContentView(baseLayout, params)

        var edit = EditText(this)
        edit.hint= "입력하세요"
        baseLayout.addView(edit)

        var btn = Button(this)
        btn.text= "버튼입니다."
        btn.setBackgroundColor(Color.rgb(0, 122, 0))
        baseLayout.addView(btn)

        var tes = TextView(this)
        tes.textSize= 30F
        tes.setTextColor(Color.MAGENTA)
        baseLayout.addView(tes)

        btn.setOnClickListener{
            var sentence : String = edit.text.toString()
            tes.text = sentence
        }
    }
}