package com.example.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    int[] newArray1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        newArray1= new int[]{
                R.id.menu21,R.id.menu22,R.id.menu23,R.id.menu24,R.id.menu25,R.id.menu26,R.id.menu27,R.id.menu28,R.id.menu29,
                R.id.menu30,R.id.menu31,R.id.menu32,


        };
    }


    public void imgbtnclick(View view) {

       for(int i =0;i<newArray1.length;i++)
       {
           if(view.getId() == newArray1[i]){
               int value1 = i+1;
               Log.i("FIRST1",String.valueOf(value1));
               Intent intent2 = new Intent (MainActivity2.this, ThirdActivity3.class);
               intent2.putExtra("value",String.valueOf(value1));
               startActivity(intent2);


           }
       }

    }
}