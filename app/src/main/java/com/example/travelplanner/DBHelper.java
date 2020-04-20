package com.example.travelplanner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

  //Table name
  public static final String TABLE_NAME = "TRIPS";

  //Table columns
  public static final String _ID = "_id";
  public static final String TRIP = "trip";
  public static final String PASSENGER1 = "passenger1";
  public static final String PASSENGER2 = "passenger2";
  public static final String PASSENGER3 = "passenger3";
  public static final String PASSENGER4 = "passenger4";

  //Database Information
  private static final String DB_NAME = "TRIPS.db";

  //Database version
  private static final int DB_VERSION = 1;

  private static final String CREATE_TABLE = "CREATE TABLE " +
    TABLE_NAME + "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TRIP + " TEXT NOT NULL, " + PASSENGER1 + " TEXT, " +
    PASSENGER2 + " TEXT, " + PASSENGER3 + " TEXT, " + PASSENGER4 + " TEXT " + ")";

  public DBHelper(Context context) {
    super(context, DB_NAME, null, DB_VERSION);
  }

  //Creating table query
  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(CREATE_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(db);
  }
}
