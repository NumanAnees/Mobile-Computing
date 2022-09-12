package com.example.databasemc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button add,view,update,delete;
    CheckBox enroll;
    EditText n,r;
    StudentModel studentModel;
    ListView listViewStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button)findViewById(R.id.button2);
        view = (Button)findViewById(R.id.button);
        update = (Button)findViewById(R.id.button3);
        delete = (Button)findViewById(R.id.button4);
        enroll = (CheckBox)findViewById(R.id.switch1);
        n =(EditText) findViewById(R.id.name);
        r =(EditText) findViewById(R.id.name2);

        listViewStudent = findViewById(R.id.listViewStudent);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    studentModel = new StudentModel(n.getText().toString(), Integer.parseInt(r.getText().toString()), enroll.isChecked());

                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DBhelper dbHelper  = new DBhelper(MainActivity.this);
                if(!dbHelper.find( r.getText().toString())){
                    Toast.makeText(MainActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                    dbHelper.addStudent(studentModel);
                }else{
                    Toast.makeText(MainActivity.this, "Already Present", Toast.LENGTH_SHORT).show();
                }
            }
        });

      view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhelper dbHelper = new DBhelper(MainActivity.this);
                List<StudentModel> list = dbHelper.getAllStudents();
                ArrayAdapter arrayAdapter = new ArrayAdapter<StudentModel>
                        (MainActivity.this, android.R.layout.simple_list_item_1,list);
                listViewStudent.setAdapter(arrayAdapter);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                        DBhelper dbHelper = new DBhelper(MainActivity.this);
                        dbHelper.update(n.getText().toString(), r.getText().toString());
                        Toast.makeText(MainActivity.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                }
                    catch(Exception e)
                    {
                        Toast.makeText(MainActivity.this, "No such record for update", Toast.LENGTH_SHORT).show();
                    }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                DBhelper dbHelper = new DBhelper(MainActivity.this);
                dbHelper.delete(n.getText().toString(),r.getText().toString());
                Toast.makeText(MainActivity.this, "deleted Successfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "Cannot delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}