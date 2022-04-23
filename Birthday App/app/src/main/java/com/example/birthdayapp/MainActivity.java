package com.example.birthdayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void newActivity(View view) {
        inp = findViewById(R.id.nameInput);
        String name = inp.getText().toString();

        Intent send = new Intent(MainActivity.this, BirthdayCardActivity.class);
        send.putExtra("name",name);
        startActivity(send);
    }


}