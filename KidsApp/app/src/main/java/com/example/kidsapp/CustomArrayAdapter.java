package com.example.kidsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomArrayAdapter extends ArrayAdapter{
    Activity context;
    String animalList[];
    int animalImages[];

    public CustomArrayAdapter(Activity context, String animalList[], int animalImages[]) {
        super(context, 0, animalList);
        this.context=context;
        this.animalList=animalList;
        this.animalImages=animalImages;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
         LayoutInflater inflater=context.getLayoutInflater();
        View singleEntityView=inflater.inflate(
                R.layout.activity_custom_list, null,true);

        TextView txtView=singleEntityView.findViewById(R.id.ItemName);

        ImageView imgView=singleEntityView.findViewById(R.id.ImageIcon);

        txtView.setText(animalList[position]);
        imgView.setImageResource(animalImages[position]);
        return singleEntityView;
    }

}
