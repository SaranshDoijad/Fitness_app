package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    int[] newArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newArray = new int[]{
                R.id.menu1, R.id.menu2, R.id.menu3, R.id.menu4, R.id.menu5, R.id.menu6, R.id.menu7, R.id.menu8, R.id.menu9, R.id.menu10, R.id.menu11, R.id.menu12,
                R.id.menu13, R.id.menu14, R.id.menu15
        };


    }

    public void Imagebuttonclicked(View view) {

        for (int i = 0; i < newArray.length; i++) {

            if(view.getId()==newArray[i]){
                int value= i+1;
                Log.i("First",String.valueOf(value));
                Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }
        }
    }
}