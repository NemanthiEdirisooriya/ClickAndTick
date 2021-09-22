package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    Button btn_login;

    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText)findViewById(R.id.et_email);
        password = (EditText)findViewById(R.id.et_pass);

        btn_login = (Button)findViewById(R.id.btn_login);

        myDB = new DBHelper(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cemail = email.getText().toString();
                String cpassword = password.getText().toString();

                if(cemail.equals("")||cpassword.equals(""))
                {
                    Toast.makeText(LoginActivity.this,"Please enter the credentials",Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean result = myDB.checkemailpassword(cemail,cpassword);
                    if (result== true){
                        Intent intent = new Intent (getApplicationContext(),Navigation_Drawerc.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this,"Invalid credentials",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        TextView btn=findViewById(R.id.tv_logo4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
}