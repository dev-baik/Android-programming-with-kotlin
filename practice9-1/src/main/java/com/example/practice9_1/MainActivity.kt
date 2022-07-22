package com.example.practice9_1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyGraphicView(this))
    }

    private class MyGraphicView(context: Context?) : View(context) {
        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            val paint = Paint()
            paint.isAntiAlias = true
            paint.strokeWidth = 50F
            canvas.drawLine(50F, 50F, 600F, 50F, paint)
            paint.strokeCap = Paint.Cap.ROUND
            canvas.drawLine(50F, 150F, 600F, 150F, paint)

            val rectF = RectF()
            rectF[100f, 200f, (100 + 400).toFloat()] = (100 + 200).toFloat()
            canvas.drawOval(rectF, paint)

            rectF[100f, 300f, (100 + 200).toFloat()] = (300 + 200).toFloat()
            canvas.drawArc(rectF, 40F, 110F, true, paint)

            paint.color = Color.BLUE
            rectF[100f, 600f, (100 + 200).toFloat()] = (600 + 200).toFloat()
            canvas.drawRect(rectF, paint)

            paint.color = Color.argb(0x88, 0xff, 0x00, 0x00)
            rectF[150f, 650f, (150 + 200).toFloat()] = (650 + 200).toFloat()
            canvas.drawRect(rectF, paint)
        }
    }
}