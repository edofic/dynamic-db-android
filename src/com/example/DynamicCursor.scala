package com.example

import language.dynamics
import android.database.Cursor
import DynamicCursor._

/**
 * User: andraz
 * Date: 12/8/12
 * Time: 6:43 PM
 */
trait DynamicCursor extends Dynamic{ this: Cursor =>

  def selectDynamic(name: String) = {
    val index = getColumnIndex(name)
    getType(index) match {
      case Cursor.FIELD_TYPE_BLOB => BlobColumn(getBlob(index))
      case Cursor.FIELD_TYPE_FLOAT => FloatColumn(getDouble(index))
      case Cursor.FIELD_TYPE_INTEGER => IntColumn(getLong(index))
      case Cursor.FIELD_TYPE_NULL => NullColumn
      case Cursor.FIELD_TYPE_STRING => StringColumn(getString(index))
    }
  }
}

object DynamicCursor{
  case object WrongTypeException extends Exception("wrong type of column")
  sealed trait Column{
    def b: Array[Byte] = throw WrongTypeException
    def f: Double = throw WrongTypeException
    def i: Long = throw WrongTypeException
    def n: Null = throw WrongTypeException
    def s: String = throw WrongTypeException
  }
  case class BlobColumn(blob: Array[Byte]) extends Column{
    override def b = blob
  }
  case class FloatColumn(value: Double) extends Column{
    override def f = value
  }
  case class IntColumn(value: Long) extends Column{
    override def i = value
  }
  case object NullColumn extends Column{
    override def n = null
  }
  case class StringColumn(str: String) extends Column{
    override def s = str
  }

  implicit class RichCursor(cursor: Cursor) extends AnyVal{
    def dynamic = new WrappedCursor(cursor) with DynamicCursor
  }
}
