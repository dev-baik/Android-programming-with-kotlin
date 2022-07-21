package com.example.practice13_2

import android.media.MediaPlayer
import android.os.Bundle
import android.os.SystemClock
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.practice13_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    lateinit var mPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        mPlayer = MediaPlayer.create(this, R.raw.song1)
        binding.seekBar1.max = mPlayer.duration


        binding.switch1.setOnClickListener {

            if(binding.switch1.isChecked) {
                mPlayer = MediaPlayer.create(this, R.raw.song1)
                mPlayer.seekTo(binding.seekBar1.progress)
                mPlayer.start()

                object : Thread(){
                    override fun run() {
                        if(mPlayer == null)
                            return
                        while(mPlayer.isPlaying) {
                            binding.seekBar1.progress = mPlayer.currentPosition
                            SystemClock.sleep(200)
                        }

                    }
                }.start()
            } else {
                binding.seekBar1.progress = 0
                mPlayer.stop()
                mPlayer.reset()
            }
        }

        binding.seekBar1.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    if(fromUser){
                        if(binding.switch1.isChecked) {
                            mPlayer.pause()
                            mPlayer.seekTo(progress)
                            mPlayer.start()
                        }
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }

            }
        )
    }
}