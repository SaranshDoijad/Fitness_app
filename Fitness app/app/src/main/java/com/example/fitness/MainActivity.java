package com.example.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Intent i,j,k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);

        i=new Intent(MainActivity.this,SecondActivity.class);
        j=new Intent(MainActivity.this,MainActivity2.class);
        k=new Intent(MainActivity.this,Diet.class);

    }

    public void get(View view) {

        startActivity(i);
    }

    public void take(View view) {

        startActivity(j);
    }

    public void make(View view) {
        startActivity(k);
    }
}