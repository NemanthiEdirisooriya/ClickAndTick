package com.example.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


        public DBHelper(Context context) {
            super(context,"Login.db",null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase myDB) {
            myDB.execSQL("create Table users(name Text,registerno Text primary key,email Text,password Text)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
            myDB.execSQL("drop Table if exists users");
        }

        public Boolean insertData(String name,String registerno,String email,String password){
            SQLiteDatabase myDB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name",name);
            contentValues.put("registerno",registerno);
            contentValues.put("email",email);
            contentValues.put("password",password);
            long result = myDB.insert("users",null,contentValues);

            if(result == -1){
                return false;
            }
            else{
                return true;
            }
        }

        public Boolean checkregisterno(String registerno)
        {
            SQLiteDatabase myDB = this.getWritableDatabase();
            Cursor cursor = myDB.rawQuery("select * from users where registerno = ?",new String[] {registerno});
            if(cursor.getCount()>0){
                return true;
            }
            else{
                return false;
            }
        }
        public Boolean checkemailpassword(String email,String password)
        {
            SQLiteDatabase myDB = this.getWritableDatabase();
            Cursor cursor = myDB.rawQuery("select * from users where email = ? and password = ?",new String[] {email,password});
            if(cursor.getCount()>0){
                return true;
            }
            else{
                return false;
            }
        }

    public Cursor Viewd(){

        SQLiteDatabase sqLiteDatabase =  this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(" select *  from  users " ,null);
        return cursor;
    }

    }
