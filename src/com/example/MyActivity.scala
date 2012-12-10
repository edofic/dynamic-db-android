package com.example

import android.app.Activity
import android.os.Bundle
import android.database.sqlite.SQLiteDatabase
import DynamicCursorRaw._

/**
 * User: andraz
 * Date: 12/8/12
 * Time: 6:35 PM
 */
class MyActivity extends Activity{
  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main)
  }

  def test() {
    val db = new DbHelper(this).getWritableDatabase
    val stream = all(db).toStream
  }

  def all(db: SQLiteDatabase) =
    db.query(
      "demo",
      Array("foo", "bar", "baz"),
      null, null, null, null, null
    )
}
