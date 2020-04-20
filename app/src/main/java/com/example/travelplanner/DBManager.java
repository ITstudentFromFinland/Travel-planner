package com.example.travelplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
  private DBHelper dbHelper;
  private Context context;
  private SQLiteDatabase database;

  public DBManager(Context c) {
    context = c;
  }

  public DBManager open() throws SQLException {
    dbHelper = new DBHelper(context);
    database = dbHelper.getWritableDatabase();
    return this;
  }

  public void close() {
    dbHelper.close();
  }

  public void insert(String name, String passenger1, String passenger2, String passenger3, String passenger4) {
    ContentValues contentValue = new ContentValues();
    contentValue.put(DBHelper.TRIP, name);
    contentValue.put(DBHelper.PASSENGER1, passenger1);
    contentValue.put(DBHelper.PASSENGER2, passenger2);
    contentValue.put(DBHelper.PASSENGER3, passenger4);
    contentValue.put(DBHelper.PASSENGER4, passenger4);
    database.insert(DBHelper.TABLE_NAME, null, contentValue);
  }

  public Cursor fetch() {
    String[] columns = new String[] { DBHelper._ID, DBHelper.TRIP, DBHelper.PASSENGER1,
    DBHelper.PASSENGER2, DBHelper.PASSENGER3, DBHelper.PASSENGER4};
    Cursor cursor = database.query(DBHelper.TABLE_NAME, columns, null, null, null, null, null);
    if(cursor != null) {
      cursor.moveToFirst();
    }
    return cursor;
  }

  public int update(long _id, String name, String passenger1, String passenger2, String passenger3, String passenger4) {
    ContentValues contentValues = new ContentValues();
    contentValues.put(DBHelper.TRIP, name);
    contentValues.put(DBHelper.PASSENGER1, passenger1);
    contentValues.put(DBHelper.PASSENGER2, passenger2);
    contentValues.put(DBHelper.PASSENGER3, passenger3);
    contentValues.put(DBHelper.PASSENGER4, passenger4);
    int i = database.update(DBHelper.TABLE_NAME, contentValues, DBHelper._ID + " = " + _id, null);
    return i;
    }

    public void delete(long _id) {
    database.delete(DBHelper.TABLE_NAME, DBHelper._ID + "=" + _id, null);
  }
}
