package com.example.practice9_3

import android.R
import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.practice9_3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var graphicView: MyGraphicView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        graphicView = MyGraphicView(this)
        binding.pictureLayout.addView(graphicView)
        clickIcons()
    }

    private fun clickIcons() {
        binding.zoomin.setOnClickListener {
            scaleX += 0.2f
            scaleY += 0.2f
            graphicView.invalidate()
        }

        binding.zoomout.setOnClickListener {
            scaleX -= 0.2f
            scaleY -= 0.2f
            graphicView.invalidate()
        }

        binding.zoomrotate.setOnClickListener {
            angle += 20
            graphicView.invalidate()
        }

        binding.zoombright.setOnClickListener {
            color += 0.2f
            graphicView.invalidate()
        }

        binding.zoomdark.setOnClickListener {
            color -= 0.2f
            graphicView.invalidate()
        }

        binding.zoomgray.setOnClickListener {
            satur = if (satur == 0f) 1f else 0f
            graphicView.invalidate()
        }
    }

    private class MyGraphicView(context: Context?) : View(context) {
        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            val paint = Paint()
            val array = floatArrayOf(
                color, 0f, 0f, 0f, 0f,
                0f, color, 0f, 0f, 0f,
                0f, 0f, color, 0f, 0f,
                0f, 0f, 0f, 1f, 0f
            )
            val cm = ColorMatrix(array)
            if (satur == 0f) cm.setSaturation(satur)

            paint.colorFilter = ColorMatrixColorFilter(cm)
            val picture = BitmapFactory.decodeResource(resources, R.mipmap.sym_def_app_icon)
            val picX = (this.width - picture.width) / 2f
            val picY = (this.height - picture.height) / 2f
            val cenX = this.width / 2f
            val cenY = this.height / 2f
            canvas.scale(scaleX, scaleY, cenX, cenY)
            canvas.rotate(angle, cenX, cenY)
            canvas.drawBitmap(picture, picX, picY, paint)
            picture.recycle()
        }
    }

    companion object {
        var scaleX = 1f
        var scaleY = 1f
        var angle = 0f
        var color = 1f
        var satur = 1f
    }
}