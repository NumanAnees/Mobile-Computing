package com.example.QuranApp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.QuranApp.AyahList;
import com.example.QuranApp.GenericListItem;
import com.example.QuranApp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterAyah extends RecyclerView.Adapter<RecyclerViewAdapterAyah.ViewHolder> {
    private Context context;
    private List<GenericListItem> genericListItems;

    public RecyclerViewAdapterAyah(Context context, ArrayList<GenericListItem> genericListItems) {
        this.context = context;
        this.genericListItems = genericListItems;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterAyah.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_custom_ayah_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterAyah.ViewHolder holder, int position) {
        GenericListItem genericListItem=genericListItems.get(position);
        holder.ayahArabic.setText(genericListItem.getFirstEntity());
        holder.ayahTrans.setText(genericListItem.getSecendEntity());
    }

    @Override
    public int getItemCount() {
        return genericListItems.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView ayahArabic;
        TextView ayahTrans;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ayahArabic=itemView.findViewById(R.id.ayahArabic);
            ayahTrans=itemView.findViewById(R.id.ayahTrans);
        }

        @Override
        public void onClick(View view) {


        }
    }

}
