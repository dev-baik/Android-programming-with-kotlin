package com.example.practice12_2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context) : SQLiteOpenHelper(context, "groupDB", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        var tableCreSql = "create table groupTBL ( gName char(20) primary key, gNumber integer);"
        p0!!.execSQL(tableCreSql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("drop table if exists groupTBL")
        onCreate(p0)
    }
}