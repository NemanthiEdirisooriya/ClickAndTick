package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class AddRates extends AppCompatActivity {

    //initialize variables
    EditText et_ar01, et_ar02, et_ar03, et_ar04, et_ar05, et_ar06;
    Button btnar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rates);

        //Assign Variables
        et_ar01 = findViewById(R.id.et_addRates1);
        et_ar02 = findViewById(R.id.et_addRates2);
        et_ar03 = findViewById(R.id.et_addRates3);
        et_ar04 = findViewById(R.id.et_addRates4);
        et_ar05 = findViewById(R.id.et_addRates5);
        et_ar06 = findViewById(R.id.et_addRates6);
        btnar = findViewById(R.id.btn_addRates);


        btnar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //initialize validation style

                String r1 = et_ar01.getText().toString();
                String r2 = et_ar02.getText().toString();
                String r3 = et_ar03.getText().toString();
                String r4 = et_ar04.getText().toString();
                String r5 = et_ar05.getText().toString();
                String r6 = et_ar06.getText().toString();


                //make the function for validations with all the parameters

                boolean check = Validateinfo(r1, r2, r3, r4, r5, r6);


                if (check == true) {
                    //on Success

                    Toast.makeText(getApplicationContext(), "Rates Successfully Added!! ", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(getApplicationContext(), AddLuxuryvehicles.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "AddRates Again!! ", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private Boolean Validateinfo(String r1, String r2, String r3, String r4, String r5, String r6) {

        if (r1.length() == 0) {
            et_ar01.requestFocus();
            et_ar01.setError("Field Cannot be Empty");
            return false;
        } else if (r2.length() == 0) {
            et_ar02.requestFocus();
            et_ar02.setError("Field Cannot be Empty");
            return false;
        } else if (r3.length() == 0) {
            et_ar03.requestFocus();
            et_ar03.setError("Field Cannot be Empty");
            return false;
        } else if (r4.length() == 0) {
            et_ar04.requestFocus();
            et_ar04.setError("Field Cannot be Empty");
            return false;
        } else if (r5.length() == 0) {
            et_ar05.requestFocus();
            et_ar05.setError("Field Cannot be Empty");
            return false;
        } else if (r6.length() == 0) {
            et_ar06.requestFocus();
            et_ar06.setError("Field Cannot be Empty");
            return false;
        } else {
            //fields are not empty
            return true;
        }


    }
    }




