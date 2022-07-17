package com.example.practice7_1

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.practice7_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        var mInflater =menuInflater
        mInflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            R.id.rotate-> {
                var num : String = binding.edit1.text.toString()
                binding.imgView.rotation= num.toFloat()
                return true
            }
            R.id.item1-> {
                item.isChecked = true
                binding.imgView.setImageResource(R.drawable.pic1)
                binding.imgView.visibility= View.VISIBLE
                return true
            }
            R.id.item2-> {
                item.isChecked = true
                binding.imgView.setImageResource(R.drawable.pic2)
                binding.imgView.visibility= View.VISIBLE
                return true
            }
            R.id.item3-> {
                item.isChecked = true
                binding.imgView.setImageResource(R.drawable.pic3)
                binding.imgView.visibility= View.VISIBLE
                return true
            }
        }
        return false
    }
}
