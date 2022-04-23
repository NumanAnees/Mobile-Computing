package com.example.birthdayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class BirthdayCardActivity extends AppCompatActivity {
    public TextView inp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_card);
        String name = getIntent().getStringExtra("name");
        inp = findViewById(R.id.Birthdaytext);
        inp.setText("Happy Birthday " + name);
    }
}