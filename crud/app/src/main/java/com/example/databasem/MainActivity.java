package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd, buttonViewAll,update, delete;
    EditText editName, editRollNumber, idname;
    Switch switchIsActive;
    ListView listViewStudent;
    StudentModel studentModel,stmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonViewAll = findViewById(R.id.buttonViewAll);
        update = findViewById(R.id.buttonUpdate);
        delete = findViewById(R.id.buttondelete);
        editName = findViewById(R.id.editTextName);
        editRollNumber = findViewById(R.id.editTextRollNumber);
        switchIsActive = findViewById(R.id.switchStudent);
        listViewStudent = findViewById(R.id.listViewStudent);
       // idname = findViewById(R.id.idname);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            StudentModel studentModel;

            @Override
            public void onClick(View v) {
                try {
                    studentModel = new StudentModel(editName.getText().toString(), Integer.parseInt(editRollNumber.getText().toString()), switchIsActive.isChecked());
                    //Toast.makeText(MainActivity.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DBhelper dbHelper  = new DBhelper(MainActivity.this);
                dbHelper.addStudent(studentModel);
            }
        });

        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBhelper dbHelper = new DBhelper(MainActivity.this);
                List<StudentModel> list = dbHelper.getAllStudents();
                ArrayAdapter arrayAdapter = new ArrayAdapter<StudentModel>
                        (MainActivity.this, android.R.layout.simple_list_item_1,list);
                listViewStudent.setAdapter(arrayAdapter);

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBhelper dbHelper = new DBhelper(MainActivity.this);
                //dbHelper.update(idname.getText().toString(),editName.getText().toString(),editRollNumber.getText().toString(),switchIsActive.isChecked());
                studentModel = new StudentModel(editName.getText().toString(), Integer.parseInt(editRollNumber.getText().toString()), switchIsActive.isChecked());
                dbHelper.update(editName.getText().toString(),editRollNumber.getText().toString());
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBhelper dbHelper = new DBhelper(MainActivity.this);
                //dbHelper.update(idname.getText().toString(),editName.getText().toString(),editRollNumber.getText().toString(),switchIsActive.isChecked());
                studentModel = new StudentModel(editName.getText().toString(), Integer.parseInt(editRollNumber.getText().toString()), switchIsActive.isChecked());
                dbHelper.delete(editName.getText().toString(),editRollNumber.getText().toString());
            }
        });



    }
}