package com.example.practice11_2

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.practice11_2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var galAdapter = MyGalleryAdapter(this, binding)
        binding.gallery1.adapter = galAdapter
    }

    class MyGalleryAdapter(var context: Context, val binding: ActivityMainBinding) : BaseAdapter() {
        var posterID = arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic1, R.drawable.pic1,R.drawable.pic3, R.drawable.pic3,R.drawable.pic3,R.drawable.pic3)
        var posterName = arrayOf("제목1", "제목2", "제목3", "제목4", "제목5", "제목6", "제목7", "제목8", "제목9", "제목10")

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var imageView1 = ImageView(context)
            imageView1.layoutParams = Gallery.LayoutParams(200, 300)
            imageView1.scaleType = ImageView.ScaleType.FIT_CENTER
            imageView1.setPadding(5,5,5,5)
            imageView1.setImageResource(posterID[p0])


            imageView1.setOnTouchListener { v, event ->
                binding.ivPoster.scaleType = ImageView.ScaleType.FIT_CENTER
                binding.ivPoster.setImageResource(posterID[p0])

                var toast = Toast(context)
                var toastView = View.inflate(context, R.layout.toast, null)
                toastView.findViewById<TextView>(R.id.textView1).text = posterName[p0]
                toast.view = toastView
                toast.show()
                false
            }

            return imageView1
        }

        override fun getItem(p0: Int): Any {
            return 0
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return posterID.size
        }
    }
}