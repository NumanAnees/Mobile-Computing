package com.example.QuranApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.example.QuranApp.R;
import com.example.QuranApp.adapter.RecyclerViewAdapter;
import com.example.QuranApp.adapter.RecyclerViewAdapterAyah;

public class AyahList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapterAyah recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayah_list);

        recyclerView=findViewById(R.id.ayahList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent=getIntent();
        String surahName=intent.getStringExtra("SurahName");

        DBHelper dbhelper=new DBHelper(this);

        ArrayList<GenericListItem> AyahList=dbhelper.displayAyah(dbhelper.getSurahNumber(surahName));
        
        recyclerViewAdapter=new RecyclerViewAdapterAyah(this,AyahList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}