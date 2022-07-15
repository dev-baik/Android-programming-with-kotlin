package com.example.practice6_3

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TabHost
import com.example.practice6_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var tabHost = binding.tabHost
        tabHost.setup()

        val tab1 = tabHost.newTabSpec("pic1")
        tab1.setIndicator("PIC1")
        tab1.setContent(R.id.pic1)
        tabHost.addTab(tab1)

        val tab2 = tabHost.newTabSpec("pic2")
        tab2.setIndicator("PIC2")
        tab2.setContent(R.id.pic2)
        tabHost.addTab(tab2)

        val tab3 = tabHost.newTabSpec("pci3")
        tab3.setIndicator("PIC3")
        tab3.setContent(R.id.pic3)
        tabHost.addTab(tab3)

        val tab4 = tabHost.newTabSpec("pic4")
        tab4.setIndicator("PIC4")
        tab4.setContent(R.id.pic4)
        tabHost.addTab(tab4)

        tabHost.currentTab = 0
    }
}
