package com.example.fypfirstdraft;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;

public class Register extends AppCompatActivity {
    EditText FName_Input, DOB, Password, ConfirmPassword, Email_Input, Contact_Input;
    TextView back;
    Button Register;
    DatePickerDialog picker;
    RadioGroup Gender;
    boolean passwordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        FName_Input=(EditText)findViewById(R.id.FName_Input);
        DOB=(EditText)findViewById(R.id.DOB_Input);
        Gender=(RadioGroup)findViewById(R.id.RadioGroup);
        Password=(EditText)findViewById(R.id.pw);
        ConfirmPassword=(EditText)findViewById(R.id.cpw);
        Email_Input=(EditText)findViewById(R.id.Email_Input);
        Contact_Input=(EditText)findViewById(R.id.Contact_Input);
        Register=(Button)findViewById(R.id.Register);
        back= (TextView) findViewById(R.id.back);

        Gender.clearCheck();
        Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
            }
        });


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, MainPage.class);
                startActivity(intent);
            }
        });
        //Setting up DatePicker on EditText
        DOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                //Date Picker Dialog
                picker = new DatePickerDialog(Register.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        DOB.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },year, month, day);
                picker.show();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

        Password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int Right=2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=Password.getRight()-Password.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=Password.getSelectionEnd();
                        if(passwordVisible){
                            Password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.visibility_off, 0);
                            Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else{
                            Password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.visibility, 0);
                            Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        Password.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        ConfirmPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int Right=2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=ConfirmPassword.getRight()-ConfirmPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=ConfirmPassword.getSelectionEnd();
                        if(passwordVisible){
                            ConfirmPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.visibility_off, 0);
                            ConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else{
                            ConfirmPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.visibility, 0);
                            ConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        ConfirmPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

    }
}

/*
ensure user keys in the deetz before proceeding to the next activity. Same for Login activity
age
Firebase/azuresql
not sure if yall want do the OTP thing. tat one need firebase also
 */
