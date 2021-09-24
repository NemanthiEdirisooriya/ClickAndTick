package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class NoticeViewCompany extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_view_company);

        DatabaseHelper dbhelper  = new DatabaseHelper(this);

        TextView  textView =  findViewById(R.id.tv_noticeview);

        Cursor cursor = dbhelper.Viewdata();

        StringBuilder stringBuilder = new StringBuilder();

        while(cursor.moveToNext()){



            textView.setText(stringBuilder);
        }



    }
}