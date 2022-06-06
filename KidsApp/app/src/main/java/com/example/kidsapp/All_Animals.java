package com.example.kidsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class All_Animals extends AppCompatActivity {
    ImageView img;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_animal);
        img=findViewById(R.id.animalShow);
        name=findViewById(R.id.animalName);

        Intent intent=getIntent();
//      img.setImageResource(R.drawable.tiger);
//        name.setText();
        String animalName=intent.getStringExtra("animalName");

        switch (animalName){
            case "Ant":
                img.setImageResource(R.drawable.ant);
                name.setText("Ant");
                break;
            case "Bat":
                img.setImageResource(R.drawable.bat);
                name.setText("Bat");
                break;
            case "Cat":
                img.setImageResource(R.drawable.cat);
                name.setText("Cat");
                break;
            case "Dog":
                img.setImageResource(R.drawable.dog);
                name.setText("Dog");
                break;
            case "Elephant":
                img.setImageResource(R.drawable.elephant);
                name.setText("Elephant");
                break;
            case "Fish":
                img.setImageResource(R.drawable.fish);
                name.setText("Fish");
                break;
            case "Giraffe":
                img.setImageResource(R.drawable.giraffe);
                name.setText("Giraffe");
                break;
            case "Horse":
                img.setImageResource(R.drawable.horse);
                name.setText("Horse");
                break;
            case "Ibex":
                img.setImageResource(R.drawable.ibex);
                name.setText("Ibex");
                break;
            case "Jaguar":
                img.setImageResource(R.drawable.jaguar);
                name.setText("Jaguar");
                break;
            case "Kangaroo":
                img.setImageResource(R.drawable.kangaroo);
                name.setText("Kangaroo");
                break;
            case "Lion":
                img.setImageResource(R.drawable.lion);
                name.setText("Lion");
                break;
            case "Monkey":
                img.setImageResource(R.drawable.monkey);
                name.setText("Monkey");
                break;
            case "Nilgai":
                img.setImageResource(R.drawable.nilgai);
                name.setText("Nilgai");
                break;
            case "Ostrich":
                img.setImageResource(R.drawable.ostrich);
                name.setText("Ostrich");
                break;
            case "Penguin":
                img.setImageResource(R.drawable.penguin);
                name.setText("Penguin");
                break;
            case "Quail":
                img.setImageResource(R.drawable.quail);
                name.setText("Quail");
                break;
            case "Rabbit":
                img.setImageResource(R.drawable.rabbit);
                name.setText("Rabbit");
                break;

            case "Snake":
                img.setImageResource(R.drawable.snake);
                name.setText("Snake");
                break;

            case "Tiger":
                img.setImageResource(R.drawable.tiger);
                name.setText("Tiger");
                break;
            case "Uguisu":
                img.setImageResource(R.drawable.uguisu);
                name.setText("Uguisu");
                break;
            case "Vicuna":
                img.setImageResource(R.drawable.vicuna);
                name.setText("Vicuna");
                break;
            case "Wolf":
                img.setImageResource(R.drawable.wolf);
                name.setText("Wolf");
                break;
            case "Xerus":
                img.setImageResource(R.drawable.xerus);
                name.setText("Xerus");
                break;
            case "Yak":
                img.setImageResource(R.drawable.yak);
                name.setText("Yak");
                break;
            case "Zebra":
                img.setImageResource(R.drawable.zebra);
                name.setText("Zebra");
                break;
            default:
                break;
        }
    }
}