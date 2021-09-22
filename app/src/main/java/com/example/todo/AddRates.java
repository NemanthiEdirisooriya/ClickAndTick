package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class AddRates extends AppCompatActivity {

    //initialize variables
    EditText et_ar01,et_ar02,et_ar03,et_ar04,et_ar05,et_ar06;
    Button btnar;

     AwesomeValidation awesomeValidation ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rates);

        //Assign Variables
        et_ar01 = findViewById(R.id.et_addRates1);
        et_ar02= findViewById(R.id.et_addRates2);
        et_ar03 = findViewById(R.id.et_addRates3);
        et_ar04 = findViewById(R.id.et_addRates4);
        et_ar05 = findViewById(R.id.et_addRates5);
        et_ar06 =findViewById(R.id.et_addRates6);
        btnar = findViewById(R.id.btn_addRates);

        //initialize validation style

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //Add validations not empty
        awesomeValidation.addValidation(this,R.id.et_addRates1, RegexTemplate.NOT_EMPTY,R.string.invalid_rate);
        awesomeValidation.addValidation(this,R.id.et_addRates2, RegexTemplate.NOT_EMPTY,R.string.invalid_rate);
        awesomeValidation.addValidation(this,R.id.et_addRates3, RegexTemplate.NOT_EMPTY,R.string.invalid_rate);
        awesomeValidation.addValidation(this,R.id.et_addRates4, RegexTemplate.NOT_EMPTY,R.string.invalid_rate);
        awesomeValidation.addValidation(this,R.id.et_addRates5, RegexTemplate.NOT_EMPTY,R.string.invalid_rate);
        awesomeValidation.addValidation(this,R.id.et_addRates6, RegexTemplate.NOT_EMPTY,R.string.invalid_rate);

        btnar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check validations
                if (awesomeValidation.validate()){
                    //on Success
                    Toast.makeText(getApplicationContext(), "Rates Successfully Added!! ", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(getApplicationContext(),AddLuxuryvehicles.class);
                    startActivity(i);

                }

                else{
                    Toast.makeText(getApplicationContext(), "Add the rates again !!!", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}