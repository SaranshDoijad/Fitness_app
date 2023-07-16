package com.example.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenOk extends AppCompatActivity {
    Animation up;
    Animation down;
    ImageView imageview;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_ok);
        ImageView imageview = findViewById(R.id.splash);
        up = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up);
        imageview.setAnimation(up);

       /* TextView textview = findViewById(R.id.appname);
        down = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        textview.setAnimation(down);*/


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        },3500);
    }
}