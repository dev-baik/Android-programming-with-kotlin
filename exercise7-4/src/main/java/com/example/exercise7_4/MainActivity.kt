package com.example.exercise7_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.exercise7_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        menu!!.add(0, 1, 0,"고양이")
        menu!!.add(0, 2, 0,"개구리")
        menu!!.add(0, 3, 0,"김석진")

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1->{
                binding.image.setImageResource(R.drawable.pic1)
                return true
            }
            2->{
                binding.image.setImageResource(R.drawable.pic2)
                return true
            }
            3->{
                binding.image.setImageResource(R.drawable.pic3)
                return true
            }
        }
        return false
    }
}