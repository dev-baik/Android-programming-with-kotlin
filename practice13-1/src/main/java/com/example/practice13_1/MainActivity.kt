package com.example.practice13_1

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.practice13_1.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var mp3Path = Environment.getExternalStorageDirectory().path+ "/"
    lateinit var selectedMP3 : String
    lateinit var mPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), Context.MODE_PRIVATE)
        var mp3List : ArrayList<String> = ArrayList()

        var listFiles = File(mp3Path).listFiles()

        for (file in listFiles!!) {
            var fileName = file.name
            var extName = fileName.substring(fileName.length - 3)
            if (extName == "mp3")
                mp3List.add(fileName)
        }

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, mp3List)
        binding.listViewMP3.choiceMode = ListView.CHOICE_MODE_SINGLE
        binding.listViewMP3.adapter = adapter
        binding.listViewMP3.setItemChecked(0, true)

        binding.listViewMP3.setOnItemClickListener { adapterView, view, i, l->
            selectedMP3 = mp3List[i]
        }

        selectedMP3 = mp3List[0]

        binding.btnPlay.setOnClickListener{
            mPlayer = MediaPlayer()
            mPlayer.setDataSource(mp3Path + selectedMP3)
            mPlayer.prepare()
            mPlayer.start()
            binding.btnPlay.isClickable= false
            binding.btnStop.isClickable= true
            binding.tvMP3.text= "실행중인 음악 : $selectedMP3"
            binding.pbMP3.visibility= View.VISIBLE
        }

        binding.btnPause.setOnClickListener {
            if(binding.btnPause.text == "일시정지"){
                binding.btnPause.text = "이어듣기"
                mPlayer.pause()
            } else{
                binding.btnPause.text = "일시정지"
                mPlayer.start()
            }
        }

        binding.btnStop.setOnClickListener{
            mPlayer.stop()
            mPlayer.reset()
            binding.btnPlay.isClickable= true
            binding.btnStop.isClickable= false
            binding.tvMP3.text= "실행중인 음악 : "
            binding.pbMP3.visibility= View.INVISIBLE
        }
        binding.btnStop.isClickable= false
    }
}