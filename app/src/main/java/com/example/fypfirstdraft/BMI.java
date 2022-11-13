package com.example.fypfirstdraft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class BMI extends AppCompatActivity {
    TextView currentHeight, currentWeight, currentAge;
    ImageView incrementAge, decrementAge, incrementWeight, decrementWeight;
    SeekBar seekbarforheight;
    Button calculatebmi, back;
    CardView male,female;

    int intWeight=50;
    int intAge=20;
    int currentProgress;
    String intProgress="0";
    String typerofuser="0";
    String weight2="50";
    String age2="20";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        getSupportActionBar().hide();
        currentAge = findViewById(R.id.currentAge);
        currentWeight = findViewById(R.id.currentWeight);
        currentHeight = findViewById(R.id.currentHeight);
        incrementAge = findViewById(R.id.add2);
        decrementAge = findViewById(R.id.minus2);
        incrementWeight = findViewById(R.id.add);
        decrementWeight = findViewById(R.id.minus);
        calculatebmi = findViewById(R.id.calculatebmi);
        seekbarforheight = findViewById(R.id.seekbarforheight);
        male = (CardView) findViewById(R.id.MaleCard);
        female = (CardView) findViewById(R.id.FemaleCard);
        back = (Button) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BMI.this, Journal.class);
                startActivity(intent);
            }
        });

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typerofuser="Male";

            }
        });


        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typerofuser="Female";
            }
        });

        seekbarforheight.setMax(300);
        seekbarforheight.setProgress(0);
        seekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress = progress;
                intProgress = String.valueOf(currentProgress);
                currentHeight.setText(intProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        incrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight=intWeight+1;
                weight2=String.valueOf(intWeight);
                currentWeight.setText(weight2);
            }
        });

        incrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge=intAge+1;
                age2=String.valueOf(intAge);
                currentAge.setText(age2);
            }
        });


        decrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge=intAge-1;
                age2=String.valueOf(intAge);
                currentAge.setText(age2);
            }
        });


        decrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intWeight=intWeight-1;
                weight2=String.valueOf(intWeight);
                currentWeight.setText(weight2);
            }
        });



        calculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(typerofuser.equals("0"))
                {
                    Toast.makeText(BMI.this,"Select your gender first",Toast.LENGTH_SHORT).show();
                }
                else if(intProgress.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"Adjust to your height first",Toast.LENGTH_SHORT).show();
                }
                else if(intAge==0 || intAge<0)
                {
                    Toast.makeText(getApplicationContext(),"Age is incorrect",Toast.LENGTH_SHORT).show();
                }

                else if(intWeight==0|| intWeight<0)
                {
                    Toast.makeText(getApplicationContext(),"Weight Is incorrect",Toast.LENGTH_SHORT).show();
                }
                else {

                    Intent intent = new Intent(BMI.this, BMI_Activity.class);
                    intent.putExtra("gender", typerofuser);
                    intent.putExtra("height", intProgress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);
                    startActivity(intent);
                }
            }
        });
    }
}