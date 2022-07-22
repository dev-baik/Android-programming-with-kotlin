package com.example.practice9_2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyGraphicView(this))
        title = "간단 그림판 (개선)"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menu.add(0, 1, 0, "선 그리기")
        menu.add(0, 2, 0, "원 그리기")
        menu.add(0, 3, 0, "사각형 그리기")
        val sMenu = menu.addSubMenu("색상 변경 >>")
        sMenu.add(0, 4, 0, "빨강")
        sMenu.add(0, 5, 0, "초록")
        sMenu.add(0, 6, 0, "파랑")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> {
                curShape = LINE // 선
                return true
            }
            2 -> {
                curShape = CIRCLE // 원
                return true
            }
            3 -> {
                curShape = RECTANGLE // 사각형
                return true
            }
            4 -> {
                curColor = Color.RED
                return true
            }
            5 -> {
                curColor = Color.GREEN
                return true
            }
            6 -> {
                curColor = Color.BLUE
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private class MyGraphicView(context: Context?) : View(context) {
        var startX = -1
        var startY = -1
        var stopX = -1
        var stopY = -1
        override fun onTouchEvent(event: MotionEvent): Boolean {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    startX = event.x.toInt()
                    startY = event.y.toInt()
                }
                MotionEvent.ACTION_MOVE, MotionEvent.ACTION_UP -> {
                    stopX = event.x.toInt()
                    stopY = event.y.toInt()
                    this.invalidate()
                }
            }
            return true
        }

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            val paint = Paint()
            paint.isAntiAlias = true
            paint.strokeWidth = 5f
            paint.style = Paint.Style.STROKE
            paint.color = curColor
            when (curShape) {
                LINE -> canvas.drawLine(
                    startX.toFloat(),
                    startY.toFloat(),
                    stopX.toFloat(),
                    stopY.toFloat(),
                    paint
                )
                CIRCLE -> {
                    val radius = Math.sqrt(
                        Math.pow((stopX - startX).toDouble(), 2.0)
                                + Math.pow((stopY - startY).toDouble(), 2.0)
                    ).toInt()
                    canvas.drawCircle(startX.toFloat(), startY.toFloat(), radius.toFloat(), paint)
                }
                RECTANGLE -> {
                    val rect = Rect(startX, startY, stopX, stopY)
                    canvas.drawRect(rect, paint)
                }
            }
        }
    }

    companion object {
        const val LINE = 1
        const val CIRCLE = 2
        const val RECTANGLE = 3
        var curShape = LINE
        var curColor = Color.DKGRAY
    }
}