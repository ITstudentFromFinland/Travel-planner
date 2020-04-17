package com.example.travelplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

  //Table name
  public static final String TABLE_NAME = "Trips";

  //Table columns
  public static final String COLUMN_ID = "TripID";
  public static final String COLUMN_TRIP = "TripName";
  public static final String COLUMN_PASSENGER1 = "Passenger1";
  public static final String COLUMN_PASSENGER2 = "Passenger2";
  public static final String COLUMN_PASSENGER3 = "Passenger3";
  public static final String COLUMN_PASSENGER4 = "Passenger4";

  //Database Information
  private static final String DATABASE_NAME = "Trips.db";

  //Database version
  private static final int DATABASE_VERSION = 1;

  public DBHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);

  /*public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
    super(context, DATABASE_NAME, factory, DATABASE_VERSION);*/
  }

  //Creating table query
  @Override
  public void onCreate(SQLiteDatabase db) {
    String CREATE_TRIP_TABLE = "CREATE TABLE " +
      TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_TRIP + " TEXT NOT NULL, " + COLUMN_PASSENGER1 + " TEXT, " +
      COLUMN_PASSENGER2 + " TEXT, " + COLUMN_PASSENGER3 + " TEXT, " + COLUMN_PASSENGER4 + " TEXT " + ")";
    db.execSQL(CREATE_TRIP_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(db);
}

  public String loadHandler() {
    String result = "";
    String query = "Select*FROM " + TABLE_NAME;
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(query, null);
    while (cursor.moveToNext()) {
      int result_0 = cursor.getInt(0);
      String result_1 = cursor.getString(1);
      result += String.valueOf(result_0) + " " + result_1 + System.getProperty("line.separator");
    }
    cursor.close();
    db.close();
    return result;
  }
  public void addHandler(DisplayEvent event) {
    ContentValues values = new ContentValues();
    values.put(COLUMN_ID, event.getID());
    values.put(COLUMN_TRIP, event.getEventDescription());
    SQLiteDatabase db = this.getWritableDatabase();
    db.insert(TABLE_NAME, null, values);
    db.close();
  }
}
