package com.example.fypfirstdraft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainPage extends AppCompatActivity {
    CardView journalCard, medicineCard, testResultCard, appointmentCard,chatbotCard, profileCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        journalCard=(CardView)findViewById(R.id.JournalCard);
        medicineCard=(CardView)findViewById(R.id.MedicineCard);
        testResultCard=(CardView)findViewById(R.id.TestResultCard);
        appointmentCard=(CardView)findViewById(R.id.AppointmentCard);
        chatbotCard=(CardView)findViewById(R.id.ChatbotCard);
        profileCard=(CardView)findViewById(R.id.ProfileCard);

        journalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, Journal.class);
                startActivity(intent);
            }
        });

        medicineCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, Medicine.class);
                startActivity(intent);
            }
        });

        testResultCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, TestResult.class);
                startActivity(intent);
            }
        });

        appointmentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, Appointment.class);
                startActivity(intent);
            }
        });

        chatbotCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, Chatbot.class);
                startActivity(intent);
            }
        });

        profileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, ProfilePage.class);
                startActivity(intent);
            }
        });
    }
}