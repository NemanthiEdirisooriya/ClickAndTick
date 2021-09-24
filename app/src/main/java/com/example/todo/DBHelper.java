package com.example.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {



    public Cursor Viewd(){

        SQLiteDatabase sqLiteDatabase =  this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(" select *  from  users " ,null);
        return cursor;
    }


