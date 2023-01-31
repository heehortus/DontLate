package com.example.dontlate

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


/**
 * personnelDBManager : 회원 개인의 약속 정보를 담은 전용 Database
 * - headID: 약속 생성자 ID - date: 약속 날짜 - title: 약속명 - place: 약속 장소
 * - deadline: 약속 마감일 - total_num: 총 인원 - current_num: (현재 시점까지) 인원
 * - state: 약속 상태 - object: 프라이빗 상태 - inviteCode: 초대 코드 - subject: 주제
 */
class serverDBManager (context: Context,
                       name: String,
                       factory: SQLiteDatabase.CursorFactory?,
                       version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE server (headID text, date text, title text, place text, deadline text, total_num Int," +
                "current_num Int, state text, object text, inviteCode text, subject text)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}