package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText name,registerno,email,password;
    Button btn_signup;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText)findViewById(R.id.et_cName);
        registerno = (EditText)findViewById(R.id.et_rNo);
        email = (EditText)findViewById(R.id.et_email);
        password = (EditText)findViewById(R.id.et_pass);

        btn_signup = (Button)findViewById(R.id.btn_signup);

        myDB = new DBHelper(this);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cname = name.getText().toString();
                String cregisterno = registerno.getText().toString();
                String cemail = email.getText().toString();
                String cpassword = password.getText().toString();

                validateinfo(cname,cregisterno,cemail,cpassword);

                if(cname.equals("")||cregisterno.equals("")||cemail.equals("")||cpassword.equals(""))
                {
                    Toast.makeText(RegisterActivity.this,"fill all the fields",Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean usercheckResult = myDB.checkregisterno(cregisterno);
                    if( usercheckResult == false)
                    {
                        Boolean regResult = myDB.insertData(cname,cregisterno,cemail,cpassword);
                        if(regResult== true){
                            Toast.makeText(RegisterActivity.this,"Registration successful",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(RegisterActivity.this,"Registration failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"user already exists.\n please sign in",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        TextView btn=findViewById(R.id.tv_logo2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }

    private boolean validateinfo(String cname, String cregisterno, String cemail, String cpassword) {


        if(cname.length()==0){
            name.requestFocus();
            name.setError("Field cannot be empty");
            return false;
        }

        if(cregisterno.length()==0){
            registerno.requestFocus();
            registerno.setError("Field cannot be empty");
            return false;
        }
        else if(!cregisterno.matches("^[+]+[0-9]{10,13}$")) {
            registerno.requestFocus();
            registerno.setError("correct format: +94xxxxxxxxxx");
            return false;
        }

        else if(cemail.length()==0){
            email.requestFocus();
            email.setError("Field cannot be empty");
            return false;
        }
        else if(!cemail.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            email.requestFocus();
            email.setError("Enter valid email");
            return false;
        }
        else if(cpassword.length()==0){
            password.requestFocus();
            password.setError("Minimum 6 characters required");
            return false;
        }
        else{
            return true;
        }
    }


}


