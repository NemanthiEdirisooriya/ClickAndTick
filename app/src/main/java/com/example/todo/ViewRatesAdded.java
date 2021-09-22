package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class ViewRatesAdded extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_rates_added);


        DatabaseHelper2 dbhelper2  = new DatabaseHelper2(this);

        TextView textView =  findViewById(R.id.tv_noticeview);

        Cursor cursor = dbhelper2.ViewRdata();

        StringBuilder stringBuilder = new StringBuilder();

        while(cursor.moveToNext()){

            stringBuilder.append("Reviews ......"+"\n Description  :" + cursor.getString(1)+"\n"
                    +"\n"+"\n" );

            textView.setText(stringBuilder);
        }




    }
}