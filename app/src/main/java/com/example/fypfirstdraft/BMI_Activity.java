package com.example.fypfirstdraft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BMI_Activity extends AppCompatActivity {
    TextView BMIDisplay,BMICategory,gender;
    Button gotoBMI;
    Intent intent;

    ImageView imageView;
    String BMI, height, weight;
    float intBMI, intHeight,intWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi2);
        imageView = (ImageView) findViewById(R.id.imageview);
        BMIDisplay = (TextView) findViewById(R.id.BMIDisplay);
        gender = (TextView) findViewById(R.id.genderDisplay);
        BMICategory = (TextView) findViewById(R.id.BMICategoryDisplay);
        gotoBMI = (Button) findViewById(R.id.gotoBMI);

        String height = getIntent().getStringExtra("height");
        String weight = getIntent().getStringExtra("weight");
        String genders = getIntent().getStringExtra("gender");
        String age = getIntent().getStringExtra("age");

        gender.setText(genders);

        intHeight = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);

        intHeight = intHeight/100;
        intBMI = intWeight/(intHeight*intHeight);

        BMI = Float.toString(intBMI);
        System.out.println(BMI);

        if(intBMI<16)
        {
            BMICategory.setText("Severe Thinness");
            imageView.setImageResource(R.drawable.cross);
        }

        else if(intBMI<16.9 && intBMI>16)
        {
            BMICategory.setText("Moderate Thinness");
            imageView.setImageResource(R.drawable.warning);
        }

        else if(intBMI<18.4 && intBMI>17)
        {
            BMICategory.setText("Mild Thinness");
            imageView.setImageResource(R.drawable.warning);
        }

        else if(intBMI<24.9 && intBMI>18.5 )
        {
            BMICategory.setText("Normal");
            imageView.setImageResource(R.drawable.okay);
        }

        else if(intBMI <29.9 && intBMI>25)
        {
            BMICategory.setText("Overweight");
            imageView.setImageResource(R.drawable.warning);
        }

        else if(intBMI<34.9 && intBMI>30)
        {
            BMICategory.setText("Obese Class I");
            imageView.setImageResource(R.drawable.warning);
        }

        else
        {
            BMICategory.setText("Obese Class II");
            imageView.setImageResource(R.drawable.cross);
        }

        BMIDisplay.setText(BMI);


        gotoBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),BMI.class);
                startActivity(intent);
            }
        });
    }
}