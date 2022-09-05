package com.example.QuranApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class Home extends AppCompatActivity {

    Button SurahActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SurahActivity=findViewById(R.id.SurahActivity);

        DBHelper dbhelper=new DBHelper(this);

        try {
            dbhelper.createDB();
        } catch (IOException ioe) {

            throw new Error("Database not created....");
        }

        try {
            dbhelper.openDB();

        }catch(SQLException sqle){

            throw sqle;
        }

        dbhelper.checkDB();

        SurahActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,SurahList.class);

                startActivity(intent);
            }
        });

    }
}