package com.example.QuranApp;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayAdapterSurah extends ArrayAdapter {
    Activity context;
    ArrayList<GenericListItem> genericListItems;



    public CustomArrayAdapterSurah(Activity context, ArrayList<GenericListItem> genericListItems) {

        super(context, 0, genericListItems);
        this.context=context;
        this.genericListItems=genericListItems;


    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View singleEntityView=inflater.inflate(
                R.layout.activity_custom_surah_view, null,true);

        TextView surahArabic=singleEntityView.findViewById(R.id.surahA);

        TextView surahEng=singleEntityView.findViewById(R.id.surahE);

//        Log.i("Position value A:",surahA.get(position));
//        Log.i("Position value E:",surahE.get(position));
        surahArabic.setText(genericListItems.get(position).getSecendEntity());
        surahEng.setText(genericListItems.get(position).getFirstEntity());
        return singleEntityView;
    }

}