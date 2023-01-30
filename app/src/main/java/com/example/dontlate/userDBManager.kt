package com.example.dontlate

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class userDBManager(context: Context,
                    name: String,
                    factory: SQLiteDatabase.CursorFactory?,
                    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE user_info (name text, ID text PRIMARY KEY, password text, profile blob)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(Category_image : String) : Boolean {
        val db = writableDatabase
        val cv = ContentValues()
        cv.put(CAL_NO1, Category_image)

        val result = db.insert(TABLE_NAME, null, cv)

        return !result.equals(-1)
    }

    companion object {
        private val DATABASE_NAME = "whenwemeet"
        private val TABLE_NAME = "user_info"
        private val CAL_NO1 = "Category_img"
    }
}