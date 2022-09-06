package com.example.QuranApp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayAdapterAyah extends ArrayAdapter {
    Activity context;
//    ArrayList<String> ayahArabicArr;
//    ArrayList<String> ayahTransArr;
ArrayList<GenericListItem> genericListItems;


    public CustomArrayAdapterAyah(Activity context, ArrayList<GenericListItem> genericListItems) {
        super(context, 0, genericListItems);
        this.context=context;
        this.genericListItems=genericListItems;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View singleEntityView=inflater.inflate(
                R.layout.activity_custom_ayah_view, null,true);

        TextView ayahArabic=singleEntityView.findViewById(R.id.ayahArabic);

        TextView ayahTrans=singleEntityView.findViewById(R.id.ayahTrans);

        ayahArabic.setText(genericListItems.get(position).getFirstEntity());
        ayahTrans.setText(genericListItems.get(position).getSecendEntity());
        return singleEntityView;
    }

}
