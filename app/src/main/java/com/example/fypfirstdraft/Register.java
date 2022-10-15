package com.example.fypfirstdraft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {
    EditText FName_Input, LName_Input, Password, ConfirmPassword, Email_Input, Contact_Input;
    TextView back;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        FName_Input=(EditText)findViewById(R.id.FName_Input);
        LName_Input=(EditText)findViewById(R.id.FName_Input);
        Password=(EditText)findViewById(R.id.pw);
        ConfirmPassword=(EditText)findViewById(R.id.cpw);
        Email_Input=(EditText)findViewById(R.id.Email_Input);
        Contact_Input=(EditText)findViewById(R.id.Contact_Input);
        Register=(Button)findViewById(R.id.Register);
        back= (TextView) findViewById(R.id.back);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, MainPage.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

    }
}

/*
ensure user keys in the deetz before proceeding to the next activity. Same for Login activity
 */