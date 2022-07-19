package com.example.practice10_3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practice10_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn1.setOnClickListener{
            var intent = Intent(applicationContext, SecondActivity::class.java)

            when (binding.rdoG.checkedRadioButtonId){
                R.id.rdoAdd->
                    intent.putExtra("Calc", "+")
                R.id.rdoSub->
                    intent.putExtra("Calc", "-")
                R.id.rdoMul->
                    intent.putExtra("Calc", "*")
                R.id.rdoDiv->
                    intent.putExtra("Calc", "/")
            }
            intent.putExtra("Num1", Integer.parseInt(binding.edtNum1.text.toString()))
            intent.putExtra("Num2", Integer.parseInt(binding.edtNum2.text.toString()))
            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            var hap = data!!.getIntExtra("Hap", 0)
            Toast.makeText(applicationContext, "합계 : $hap", Toast.LENGTH_SHORT).show()
        }
    }
}