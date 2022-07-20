package com.example.practice11_1

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.practice11_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var gadapter = MyGridAdapter(this)
        binding.gridView1.adapter= gadapter

    }

    class MyGridAdapter(var context: Context) : BaseAdapter() {
        var posterID =arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4)
        var posterTitle =arrayOf("써니", "완득이", "괴물", "몰라")

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var imageView1 = ImageView(context)
            imageView1.layoutParams= ViewGroup.LayoutParams(200, 300)
            imageView1.scaleType= ImageView.ScaleType.FIT_CENTER
            imageView1.setPadding(5, 5, 5, 5)
            imageView1.setImageResource(posterID[p0])

            imageView1.setOnClickListener{
                var dialogView1 = View.inflate(context, R.layout.item, null)
                var dlg = AlertDialog.Builder(context)

                dlg.setTitle(posterTitle[p0])
                dlg.setIcon(R.mipmap.ic_launcher)
                dlg.setNegativeButton("닫기", null)

                dialogView1.findViewById<ImageView>(R.id.ivPoster).setImageResource(posterID[p0])
                dlg.setView(dialogView1)
                dlg.show()
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