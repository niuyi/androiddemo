package com.niuyi.androiddemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DB_NAME = "demo_db";

    public static final String TABLE_NAME = "demo_data";
    public static final String COLUMNS_NAME = "name";

    private static final String SQL_TABLE_CREATE = "create table "
            + TABLE_NAME + "("
            + COLUMNS_NAME + " text"
            + ");";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_TABLE_CREATE);
    }

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
