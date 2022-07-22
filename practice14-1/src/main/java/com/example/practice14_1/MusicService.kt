package com.example.practice14_1

import android.content.Intent
import android.media.MediaPlayer
import android.os.Environment
import android.os.IBinder
import java.io.File

class MusicService: android.app.Service() {

    lateinit var  mp: MediaPlayer
    lateinit var mp3List: ArrayList<String>
    lateinit var currentMP3: String

    var playNum = 0
    var mp3Path = Environment.getExternalStorageDirectory().path + "/"

    override fun onCreate() {
        android.util.Log.i("서비스 테스트", "onCreate()")
        mp3List = ArrayList()

        var listFiles = File(mp3Path).listFiles()
        var fileName: String
        var extName: String
        for(file in listFiles!!) {
            fileName = file.name
            extName = fileName.substring(fileName.length - 3)
            if (extName == "mp3") {
                mp3List.add(fileName)
            }
        }
        super.onCreate()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        android.util.Log.i("서비스 테스트", "onStartCommand()")
//        mp = MediaPlayer.create(this, R.raw.song1)
//        mp.isLooping = true
//        mp.start()

        mp.stop()
        mp.reset()

        mp.setOnCompletionListener {
            if(playNum < mp3List.size) {
                currentMP3 = mp3List[playNum++]
                mp.setDataSource(mp3Path + currentMP3)
                mp.prepare()
                mp.start()
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        android.util.Log.i("서비스 테스트", "onDestroy()")
        mp.stop()
        super.onDestroy()
    }
}