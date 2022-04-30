package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity
{

    TextView out;
    TextView res;

    String output = "";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews()
    {
        out = (TextView)findViewById(R.id.workingsTextView);
        res = (TextView)findViewById(R.id.resultTextView);
    }

    private void setWorkings(String givenValue)
    {
        output = output + givenValue;
        out.setText(output);
    }


    public void equalsOnClick(View view)
    {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            result = (double)engine.eval(output);
        } catch (ScriptException e)
        {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if(result != null)
            res.setText(String.valueOf(result.doubleValue()));

    }

    public void clearOnClick(View view)
    {
        out.setText("");
        output = "";
        res.setText("");
    }
    public void backOnClick(View view)
    {
        String w = out.getText().toString();
        out.setText(w.substring(0, out.getText().length() - 1));
        output = output.substring(0,output.length()-1);
        res.setText("");
    }

    public void modOnClick(View view)
    {
        setWorkings("%");
    }

    public void divisionOnClick(View view)
    {
        setWorkings("/");
    }

    public void sevenOnClick(View view)
    {
        setWorkings("7");
    }

    public void eightOnClick(View view)
    {
        setWorkings("8");
    }

    public void nineOnClick(View view)
    {
        setWorkings("9");
    }

    public void timesOnClick(View view)
    {
        setWorkings("*");
    }

    public void fourOnClick(View view)
    {
        setWorkings("4");
    }

    public void fiveOnClick(View view)
    {
        setWorkings("5");
    }

    public void sixOnClick(View view)
    {
        setWorkings("6");
    }

    public void minusOnClick(View view)
    {
        setWorkings("-");
    }

    public void oneOnClick(View view)
    {
        setWorkings("1");
    }

    public void twoOnClick(View view)
    {
        setWorkings("2");
    }

    public void threeOnClick(View view)
    {
        setWorkings("3");
    }

    public void plusOnClick(View view)
    {
        setWorkings("+");
    }

    public void decimalOnClick(View view)
    {
        setWorkings(".");
    }

    public void zeroOnClick(View view)
    {
        setWorkings("0");
    }

}
