package com.example.kidsapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Alpha extends AppCompatActivity {

    String List[]={"Ant","Bat","Cat","Dog","Elephant",
            "Fish","Giraffe","Horse","Ibex","Jaguar","Kangaroo","Lion","Monkey","Nilgai","Ostrich",
            "Penguin","Quail","Rabbit","Snake","Tiger","Uguisu","Vicuna","Wolf","Xerus","Yak","Zebra"};

    int Images[]= { R.drawable.ant,R.drawable.bat,R.drawable.cat ,R.drawable.dog,R.drawable.elephant, R.drawable.fish, R.drawable.giraffe,
            R.drawable.horse,R.drawable.ibex,R.drawable.jaguar,R.drawable.kangaroo,R.drawable.lion,R.drawable.monkey,R.drawable.nilgai,R.drawable.ostrich,
            R.drawable.penguin,R.drawable.quail,R.drawable.rabbit,R.drawable.snake,
            R.drawable.tiger,R.drawable.uguisu,R.drawable.vicuna,R.drawable.wolf,R.drawable.xerus,R.drawable.yak,R.drawable.zebra};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list);

        listView=findViewById(R.id.CustomListView);

        CustomArrayAdapter customArrayAdapter=new CustomArrayAdapter(this,List,Images);

        listView.setAdapter(customArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent=new Intent(Alpha.this, All_Animals.class);
                intent.putExtra("animalName",List[i]);
                startActivity(intent);
            }
        });
    }
}