package com.example.QuranApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.QuranApp.adapter.RecyclerViewAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SurahList extends AppCompatActivity {
    EditText searchField;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_list);

        recyclerView=findViewById(R.id.surahList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchField=findViewById(R.id.searchField);
        DBHelper dbhelper=new DBHelper(this);
//        ArrayList<String> SANList;
//        SANList=dbhelper.displaySurahName("SurahNameU");
//
//        ArrayList<String> SENList;
//        SENList=dbhelper.displaySurahName("SurahNameE");

       ArrayList<GenericListItem> SurahList=dbhelper.displaySurahName();


//        Log.i("Length of SAN:",SANList.get(6));
//        Log.i("Length of SEN:",SENList.get(6));
        //CustomArrayAdapterSurah customArrayAdapter=new CustomArrayAdapterSurah(this,SurahList);

        recyclerViewAdapter=new RecyclerViewAdapter(this,SurahList);
        recyclerView.setAdapter(recyclerViewAdapter);




        searchField.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i("Before Text change",searchField.getText().toString());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        Log.i("Text change",searchField.getText().toString());
                ArrayList<GenericListItem> SurahList2;
                SurahList2=dbhelper.surahFilter(searchField.getText().toString());
                recyclerViewAdapter=new RecyclerViewAdapter(SurahList.this,SurahList2);
                recyclerView.setAdapter(recyclerViewAdapter);

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.i("After Text change",searchField.getText().toString());

            }
        });

    }
}