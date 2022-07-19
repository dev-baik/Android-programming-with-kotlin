package com.example.practice10_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice10_2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private val binding by lazy { ActivityResultBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var voteResult = intent.getIntArrayExtra("VoteCount")
        var imageName = intent.getStringArrayExtra("ImageName")

        with(binding) {
            var textV =arrayOf(textv1, textv2, textv3, textv4, textv5, textv6, textv7, textv8, textv9)
            var rbar =arrayOf(rbar1, rbar2, rbar3, rbar4, rbar5, rbar6, rbar7, rbar8, rbar9)
            var imageV =arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
                R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic1)

            var max = 0
            for (i in voteResult!!.indices) {
                textV[i].text = imageName!![i]
                rbar[i].rating = voteResult[i].toFloat()
                if (voteResult[max] < voteResult[i]) {
                    max = i
                }
            }
            imageTop.setImageResource(imageV[max])
            textTop.text = imageName!![max]

            btnReturn.setOnClickListener{
                finish()
            }
        }
    }
}
