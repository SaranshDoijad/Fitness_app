package com.example.fitness;

import static com.example.fitness.R.*;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;

public class ThirdActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    String buttonvalue;
    TextToSpeech tts;
    TextView t2;
    FloatingActionButton b2;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimerRunning;
    private long MTimeLeftinmills;
    Button  startBtn;

    static Boolean status = false;

    @SuppressLint({"MissingInflatedId", "UseCompatLoadingForColorStateLists", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_third);




        mediaPlayer = MediaPlayer.create(this, R.raw.buzzer);

        Intent intent=getIntent();
        buttonvalue =intent.getStringExtra("value");

        int intvalue=Integer.parseInt(buttonvalue);

        switch(intvalue)
        {
            case 1:
                setContentView(layout.activity1);
                break;

            case 2:
                setContentView(layout.activity2);
                break;

            case 3:
                setContentView(layout.activity3);
                break;

            case 4:
                setContentView(layout.activity4);
                break;

            case 5:
                setContentView(layout.activity5);
                break;

            case 6:
                setContentView(layout.activity6);
                break;

            case 7:
                setContentView(layout.activity7);
                break;

            case 8:
                setContentView(layout.activity8);
                break;

            case 9:
                setContentView(layout.activity9);
                break;

            case 10:
                setContentView(layout.activity10);
                break;

            case 11:
                setContentView(layout.activity11);
                break;

            case 12:
                setContentView(layout.activity12);
                break;

            case 13:
                setContentView(layout.activity13);
                break;

            case 14:
                setContentView(layout.activity14);
                break;

            case 15:
                setContentView(layout.activity15);
                break;
        }



        t2 = findViewById(id.text2);
        b2 = findViewById(id.speak2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status == false) {
                    status = true;
                    b2.setImageResource(drawable.buttun_volume_up);
                    tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {

                        @Override
                        public void onInit(int i) {
                            if (i == TextToSpeech.SUCCESS) {
                                tts.setLanguage(Locale.ENGLISH);
                                tts.setSpeechRate(1.0f);
                                tts.speak(t2.getText().toString(), TextToSpeech.QUEUE_ADD, null);


                            }
                        }

                    });
                }
                else if(status == true){

                    tts.shutdown();
                    b2.setImageResource(drawable.baseline_volume_off_24);
                    status = false;


                }

                ;}

        });



        startBtn = findViewById(R.id.startbutton);
        mtextview = findViewById(R.id.time);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MTimerRunning){
                    stoptimer();

                }else{
                    startTimer();
                }
            }
        });















    }

    private void stoptimer()
    {
        countDownTimer.cancel();
        MTimerRunning=false;
        startBtn.setText("START");

    }

    private void startTimer()
    {
        mediaPlayer.start();
        final CharSequence value1 = mtextview.getText();
        String num1 = value1.toString();
        String num2 = num1.substring(0,2);
        String num3 = num1.substring(3,5);
        final int number = Integer.valueOf(num2) *60 + Integer.valueOf(num3);
         MTimeLeftinmills = number * 1000;
        countDownTimer = new CountDownTimer(MTimeLeftinmills,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                MTimeLeftinmills = millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {
                int newvalue = Integer.valueOf(buttonvalue)+1;
                if(newvalue<=7){
                    Intent intent = new Intent(ThirdActivity.this,ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }else{
                    newvalue =1;
                    Intent intent = new Intent(ThirdActivity.this,ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("values",String.valueOf(newvalue));
                    startActivity(intent);
                }
            }
        }.start();
        startBtn.setText("PAUSE");

        MTimerRunning=true;

    }



    private void updateTimer()
    {
        int minutes = (int) MTimeLeftinmills/60000;
        int seconds = (int) MTimeLeftinmills % 60000/1000;
        mediaPlayer.start();
//        String timeLeftText=" ";
//        if(minutes<10) {
//            timeLeftText = "0";
//            timeLeftText = timeLeftText + minutes + ":";
//
//            if (seconds < 10) {
//                timeLeftText += "0";
//                timeLeftText += seconds;
//                mtextview.setText(timeLeftText);
//            }
//        }
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mtextview.setText(timeLeftFormatted);


}
    @Override
    public void onBackPressed() {
        timerStop();
        stopTextToSpeech();
        super.onBackPressed();

    }

    private void timerStop(){
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
    private void stopTextToSpeech() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();

        }
    }
}
