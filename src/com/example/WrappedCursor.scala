package com.example

import android.content.ContentResolver
import android.database.CharArrayBuffer
import android.database.ContentObserver
import android.database.Cursor
import android.database.DataSetObserver
import android.net.Uri
import android.os.Bundle

/**
 * User: andraz
 * Date: 12/8/12
 * Time: 6:41 PM
 */
class WrappedCursor(cursor: Cursor) extends Cursor{

  def getCount: Int = cursor.getCount
  
  def unregisterDataSetObserver(dataSetObserver: DataSetObserver) {
    cursor.unregisterDataSetObserver(dataSetObserver)
  }
    
  def moveToFirst: Boolean = cursor.moveToFirst
  
  def getColumnIndexOrThrow(s: String): Int = cursor.getColumnIndexOrThrow(s)
  
  def getFloat(i: Int): Float = cursor.getFloat(i)
  
  def getColumnCount: Int = cursor.getColumnCount
  
  def getLong(i: Int): Long = cursor.getLong(i)
  
  def moveToLast: Boolean = cursor.moveToLast
  
  def getPosition: Int = cursor.getPosition
  
  def isLast: Boolean = cursor.isLast
  
  def moveToPosition(i: Int): Boolean = cursor.moveToPosition(i)
  
  def respond(bundle: Bundle): Bundle = cursor.respond(bundle)
  
  def getColumnName(i: Int): String = cursor.getColumnName(i)
  
  def getInt(i: Int): Int = cursor.getInt(i)
  
  def setNotificationUri(contentResolver: ContentResolver, uri: Uri) {
    cursor.setNotificationUri(contentResolver, uri)
  }
  
  def isFirst: Boolean = cursor.isFirst
  
  def getString(i: Int): String = cursor.getString(i)
  
  def deactivate {
    cursor.deactivate
  }
  
  def getExtras: Bundle = cursor.getExtras
  
  def unregisterContentObserver(contentObserver: ContentObserver) {
    cursor.unregisterContentObserver(contentObserver)
  }
  
  def getColumnIndex(s: String): Int = cursor.getColumnIndex(s)
  
  def getWantsAllOnMoveCalls: Boolean = cursor.getWantsAllOnMoveCalls
  
  def requery: Boolean = cursor.requery
  
  def getBlob(i: Int): Array[Byte] = cursor.getBlob(i)
  
  def moveToNext: Boolean = cursor.moveToNext
  
  def move(i: Int): Boolean = cursor.move(i)
  
  def registerDataSetObserver(dataSetObserver: DataSetObserver) {
    cursor.registerDataSetObserver(dataSetObserver)
  }
  
  def moveToPrevious: Boolean = cursor.moveToPrevious
  
  def isBeforeFirst: Boolean = cursor.isBeforeFirst
  
  def isAfterLast: Boolean = cursor.isAfterLast
  
  def copyStringToBuffer(i: Int, charArrayBuffer: CharArrayBuffer) {
    cursor.copyStringToBuffer(i, charArrayBuffer)
  }
  
  def getShort(i: Int): Short = cursor.getShort(i)
  
  def registerContentObserver(contentObserver: ContentObserver) {
    cursor.registerContentObserver(contentObserver)
  }
  
  def getDouble(i: Int): Double = cursor.getDouble(i)
  
  def getColumnNames: Array[String] = cursor.getColumnNames
  
  def isNull(i: Int): Boolean = cursor.isNull(i)
  
  def close {
    cursor.close
  }
  
  def isClosed: Boolean = cursor.isClosed

  def getType(i: Int) = cursor.getType(i)
}

    
  

