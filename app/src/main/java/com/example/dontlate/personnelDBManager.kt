package com.example.dontlate

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * personnelDBManager : 회원 개인의 약속 정보를 담은 전용 Database
 * - date: 약속 날짜
 * - time: 약속 참여 시간
 * - title: (약속 주선자가 작성한) 약속 제목
 * - state: 약속 상태 (약속 대기, 약속 확정, 약속 취소)
 */
class personnelDBManager (context : Context,
                          name : String,
                          factory : SQLiteDatabase.CursorFactory?,
                          version : Int
) : SQLiteOpenHelper (context, name, factory, version) {
    var dbName : String = name

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE $dbName (date text, title text, time text, place text, state text)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}