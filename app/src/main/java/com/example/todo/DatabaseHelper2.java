package com.example.todo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper2 extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "RatesDatabase";


    public DatabaseHelper2(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery = "CREATE TABLE Rate ( id INTEGER PRIMARY KEY AUTOINCREMENT, Company_name String, hybrid TEXT)";
        sqLiteDatabase.execSQL(sqlQuery);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sqlQuery = "DROP TABLE IF EXISTS Rate";
        sqLiteDatabase.execSQL(sqlQuery);
        onCreate(sqLiteDatabase);


    }

    public Cursor ViewRdata(){

        SQLiteDatabase sqLiteDatabase =  this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(" select *  from  Rate " ,null);
        return cursor;
    }


}
