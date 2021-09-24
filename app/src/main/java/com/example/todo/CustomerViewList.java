package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class CustomerViewList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view_list);

        DBHelper dbhelper  = new DBHelper(this);

        TextView textView =  findViewById(R.id.tv_customerList_view);

        Cursor cursor = dbhelper.Viewd();

        StringBuilder stringBuilder = new StringBuilder();

        while(cursor.moveToNext()){

            stringBuilder.append("Customer details : ......"+"\n Customer Name  :" + cursor.getString(0)+"\n Contact Number  :" + cursor.getString(1)+"\n Email address :" + cursor.getString(2)+"\n Password :" + cursor.getString(3)
                    +"\n"+"\n" );

            textView.setText(stringBuilder);
        }

    }
}