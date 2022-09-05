package com.example.QuranApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SurahList extends AppCompatActivity {
    EditText searchField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_list);

        searchField=findViewById(R.id.searchField);
        DBHelper dbhelper=new DBHelper(this);
//        ArrayList<String> SANList;
//        SANList=dbhelper.displaySurahName("SurahNameU");
//
//        ArrayList<String> SENList;
//        SENList=dbhelper.displaySurahName("SurahNameE");

       ArrayList<GenericListItem> SurahList=dbhelper.displaySurahName();
        ListView surahList=findViewById(R.id.surahList);

//        Log.i("Length of SAN:",SANList.get(6));
//        Log.i("Length of SEN:",SENList.get(6));
        CustomArrayAdapterSurah customArrayAdapter=new CustomArrayAdapterSurah(this,SurahList);

        surahList.setAdapter(customArrayAdapter);




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
                CustomArrayAdapterSurah customArrayAdapter2;
                customArrayAdapter2=new CustomArrayAdapterSurah(SurahList.this,SurahList2);
                surahList.setAdapter(customArrayAdapter2);

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.i("After Text change",searchField.getText().toString());

            }
        });

        surahList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.i("Clicked on list:",String.valueOf(i));
                Intent intent=new Intent(SurahList.this,AyahList.class);
                TextView text=(TextView)view.findViewById(R.id.surahA);

                String surahName = text.getText().toString();
                //String selectedFromList = (String) (surahList.getItemAtPosition(i));
                Log.i("Itemmm String::>:",surahName);

                intent.putExtra("SurahName", surahName);
                startActivity(intent);
            }
        });
    }
}