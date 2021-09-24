package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Company_Details extends AppCompatActivity {

    TextView motorplus,ceylinco,allianz,fairfirst,aia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);

        motorplus=findViewById(R.id.motorplus);
        ceylinco=findViewById(R.id.ceylinco);
        allianz=findViewById(R.id.allianz);
        fairfirst=findViewById(R.id.fairfirst);
        aia=findViewById(R.id.aia);

        motorplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.srilankainsurance.com/en/personal/motor-insurance/motor-plus");
            }
        });

        ceylinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.ceylinco-insurance.com/products/motor-insurance/");
            }
        });

        allianz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.gocompare.com/car-insurance/");
            }
        });

        fairfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.fairfirst.lk/motor-insurance-online-shop/");
            }
        });

        aia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.aialife.com.lk/en/index.html");
            }
        });
    }

    private void gotoUrl(String s) {

        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}