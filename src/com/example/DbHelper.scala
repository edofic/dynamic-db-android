package com.example

import android.database.sqlite.{SQLiteDatabase, SQLiteOpenHelper}
import android.content.Context

/**
 * User: andraz
 * Date: 12/8/12
 * Time: 7:33 PM
 */
class DbHelper(context: Context) extends
  SQLiteOpenHelper(context, "demoDb", null, 1) {

  def onCreate(db: SQLiteDatabase) {
    db.execSQL(
      """
        |CREATE TABLE demo(
        |   foo INTEGER,
        |   bar real,
        |   baz text
        |);
      """.stripMargin)
  }

  def onUpgrade(db: SQLiteDatabase, from: Int, to: Int) {
    if (from==to){
      db.execSQL("DROP TABLE * IF EXISTS;")
    }
    onCreate(db)
  }
}
