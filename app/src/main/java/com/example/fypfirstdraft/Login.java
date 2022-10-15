package com.example.fypfirstdraft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
EditText Email_Input;
Button Login;
TextView loginQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email_Input=(EditText)findViewById(R.id.Email_Input);
        Login=(Button)findViewById(R.id.Register);
        loginQuestion=(TextView)findViewById(R.id.LoginPageQuestion);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, MainPage.class);
                startActivity(intent);
            }
        });

        loginQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

    }
}

/*
ensure user keys in the deetz before proceeding to the next activity. Same for Register activity
 */