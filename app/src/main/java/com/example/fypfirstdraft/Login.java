package com.example.fypfirstdraft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
EditText FName_Input, LName_Input, Email_Input, Contact_Input;
Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FName_Input=(EditText)findViewById(R.id.FName_Input);
        LName_Input=(EditText)findViewById(R.id.FName_Input);
        Email_Input=(EditText)findViewById(R.id.Email_Input);
        Contact_Input=(EditText)findViewById(R.id.Contact_Input);
        Register=(Button)findViewById(R.id.Register);

        Register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, MainPg.class);
                startActivity(intent);
            }
        });
    }
}