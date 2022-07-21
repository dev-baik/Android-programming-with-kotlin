package com.example.practice12_2

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practice12_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var myDBHelper =  MyDBHelper(this)
        var sqlDB : SQLiteDatabase

        with(binding) {
            btnInit.setOnClickListener {
                sqlDB = myDBHelper.writableDatabase
                myDBHelper.onUpgrade(sqlDB, 1, 2)
                sqlDB.close()

                btnSelect.callOnClick()
            }

            btnInsert.setOnClickListener {
                sqlDB = myDBHelper.writableDatabase
                var name = edtName.text.toString()
                var number = edtNumber.text.toString().toInt()

                sqlDB.execSQL("insert into groupTBL values ('$name', $number);")
                sqlDB.close()
                Toast.makeText(applicationContext, "입력됨", Toast.LENGTH_LONG).show()
                edtName.setText("")
                edtNumber.setText("")
                btnSelect.callOnClick()
            }

            btnSelect.setOnClickListener {
                sqlDB = myDBHelper.readableDatabase
                var cursor = sqlDB.rawQuery("select * from groupTBL;", null)

                var strName = "그룹이름" + "\r\n" + "--------------" + "\r\n"
                var strNumber = "인 원" + "\r\n" + "--------------" + "\r\n"
                while (cursor.moveToNext()) {
                    strName += cursor.getString(0) + "\r\n"
                    strNumber += cursor.getString(1) + "\r\n"
                }

                edtNameResult.text = strName
                edtNumberResult.text = strNumber
                cursor.close()
                sqlDB.close()
            }

            btnUpdate.setOnClickListener {
                sqlDB = myDBHelper.writableDatabase
                var name = edtName.text.toString()
                var number = edtNumber.text.toString().toInt()

                sqlDB.execSQL("update groupTBL set gNumber=$number where gName='$name';")
                sqlDB.close()

                btnSelect.callOnClick()
            }

            btnDelete.setOnClickListener {
                sqlDB = myDBHelper.writableDatabase
                var name = edtName.text.toString()
                sqlDB.execSQL("delete from groupTBL where gName = '$name';")
                sqlDB.close()

                btnSelect.callOnClick()
            }
        }
    }
}