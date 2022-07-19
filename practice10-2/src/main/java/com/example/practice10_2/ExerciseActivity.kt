package com.example.practice10_2

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.practice10_2.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {
    private val binding by lazy { ActivityExerciseBinding.inflate(layoutInflater) }
    private lateinit var imageArray: Array<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var voteResult = intent.getIntArrayExtra("VoteCount")

        with(binding) {
            imageArray = arrayOf(image1, image2, image3, image4, image5, image6, image7, image8, image9)
            var imageV = arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
                R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic1)

            btnReturn.setOnClickListener{
                finish()
            }

            var votePrefer: Array<IntArray> = Array(2) { IntArray(9) }

            for (i in voteResult!!.indices) {
                votePrefer[0][i] = i
                votePrefer[1][i] = voteResult[i]
            }

            for (i in 1 until votePrefer[0].size) {
                for (j in 0 until votePrefer[0].size - i) {
                    if(votePrefer[1][j] <= votePrefer[1][j+1]) {
                        for(k in votePrefer.indices) {
                            var temp = votePrefer[k][j]
                            votePrefer[k][j] = votePrefer[k][j+1]
                            votePrefer[k][j+1] = temp
                        }
                    }
                }
            }

            for (i in imageArray.indices) {
                imageArray[i].setImageResource(imageV[votePrefer[0][i]])
            }

            btnStart.setOnClickListener {
                viewFliper.flipInterval = 1000
                viewFliper.startFlipping()
            }

            btnStop.setOnClickListener {
                viewFliper.stopFlipping()
            }

            btnReturn.setOnClickListener {
                finish()
            }
        }
    }
}
