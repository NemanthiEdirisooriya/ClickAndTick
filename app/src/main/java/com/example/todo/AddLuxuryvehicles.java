package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.todo.ui.home.HomeFragment;

public class AddLuxuryvehicles extends AppCompatActivity {

    Button btnluxury;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_luxuryvehicles);


        btnluxury =findViewById(R.id.btn_luxryv);

        btnluxury.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Luxury vehicles  Successfully Added!! ", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), Navigation_Drawerc.class);
               startActivity(i);
            }
        });


    }
}