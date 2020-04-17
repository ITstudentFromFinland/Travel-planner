package com.example.travelplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
  private DBHelper dbHelper;
  private Context context;
  private SQLiteDatabase database;

  public DBManager(Context c) {
    context = c;
  }

  public DBManager open() throws SecurityException {
    dbHelper = new DBHelper(context);
    database = dbHelper.getWritableDatabase();
    return this;
  }

  public void close() {
    dbHelper.close();
  }

  public void insert(String name, String passenger1, String passenger2, String passenger3, String passenger4) {
    ContentValues contentValue = new ContentValues();
    contentValue.put(DBHelper.COLUMN_TRIP, name);
    contentValue.put(DBHelper.COLUMN_PASSENGER1, passenger1);
    contentValue.put(DBHelper.COLUMN_PASSENGER2, passenger2);
    contentValue.put(DBHelper.COLUMN_PASSENGER3, passenger4);
    contentValue.put(DBHelper.COLUMN_PASSENGER4, passenger4);
    database.insert(DBHelper.TABLE_NAME, null, contentValue);
  }

  public Cursor fetch() {
    String[] columns = new String[] { DBHelper.COLUMN_ID, DBHelper.COLUMN_TRIP, DBHelper.COLUMN_PASSENGER1,
    DBHelper.COLUMN_PASSENGER2, DBHelper.COLUMN_PASSENGER3, DBHelper.COLUMN_PASSENGER4};
    Cursor cursor = database.query(DBHelper.TABLE_NAME, columns, null, null, null, null, null);
    if(cursor != null) {
      cursor.moveToFirst();
    }
    return cursor;
  }

  public int update(long _id, String name, String passenger1, String passenger2, String passenger3, String passenger4) {
    ContentValues contentValues = new ContentValues();
    contentValues.put(DBHelper.COLUMN_TRIP, name);
    contentValues.put(DBHelper.COLUMN_PASSENGER1, passenger1);
    contentValues.put(DBHelper.COLUMN_PASSENGER2, passenger2);
    contentValues.put(DBHelper.COLUMN_PASSENGER3, passenger3);
    contentValues.put(DBHelper.COLUMN_PASSENGER4, passenger4);
    int i = database.update(DBHelper.TABLE_NAME, contentValues, DBHelper.COLUMN_ID + " = " + _id, null);
    return i;
    }

    public void delete(long _id) {
    database.delete(DBHelper.TABLE_NAME, DBHelper.COLUMN_ID + "=" + _id, null);
  }
}
