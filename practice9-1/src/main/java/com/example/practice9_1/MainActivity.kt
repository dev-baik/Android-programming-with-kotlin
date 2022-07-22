package com.example.practice9_1

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyGraphicView(this))
    }

    private class MyGraphicView(context: Context?) : View(context) {
        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            val paint = Paint()

            paint.color = Color.BLACK
            paint.strokeWidth = 50F
            canvas.drawLine(70F, 70F, 370F, 70F, paint)
            paint.strokeCap = Paint.Cap.ROUND

            canvas.drawOval(RectF(70F, 210F, 70F + 300F, 210F + 140F), paint)
            canvas.drawArc(RectF(70F, 280F, 70F + 300F, 280F + 210F), 35F, 100F, true, paint)

            val rect1 = Rect(100, 600, 100 + 200, 600 + 200)
            paint.color = Color.BLUE
            canvas.drawRect(rect1, paint)

            val rect2 = Rect(100 + 60, 600 + 60, 100 + 60 + 200, 600 + 60 + 200)
            paint.color = Color.argb(120, 255, 0, 0)
            canvas.drawRect(rect2, paint)
        }
    }
}