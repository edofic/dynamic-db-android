package com.example

import android.database.Cursor


/**
 * User: andraz
 * Date: 12/9/12
 * Time: 2:41 PM
 */
trait DynamicCursorRaw extends Dynamic{ this: Cursor =>

  def selectDynamic(name: String) =
    getColumn(getColumnIndex(name))

  def getColumn(index: Int) =
    getType(index) match {
    case Cursor.FIELD_TYPE_BLOB => getBlob(index)
    case Cursor.FIELD_TYPE_FLOAT => getDouble(index)
    case Cursor.FIELD_TYPE_INTEGER => getLong(index)
    case Cursor.FIELD_TYPE_NULL => null
    case Cursor.FIELD_TYPE_STRING => getString(index)
  }

  def toSeq = (0 until getColumnCount) map getColumn
}

object DynamicCursorRaw{
  def CursorStream(cursor: DynamicCursorRaw with Cursor) = {
    def loop(): Stream[Seq[Any]] = {
      if(cursor.isAfterLast)
        Stream.empty[Seq[Any]]
      else {
        val snapshot = cursor.toSeq
        cursor.moveToNext()
        snapshot #:: loop()
      }
    }
    cursor.moveToFirst()
    loop()
  }

  implicit class RichCursorRaw(cursor: Cursor) extends AnyVal{
    def dynamicRaw = new WrappedCursor(cursor) with DynamicCursorRaw
    def toStream = CursorStream(dynamicRaw)
  }
}

