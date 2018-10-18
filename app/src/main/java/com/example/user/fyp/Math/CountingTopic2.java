package com.example.user.fyp.Math;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fyp.Activities.TestOverActivity;
import com.example.user.fyp.R;

import java.util.Random;

public class CountingTopic2 extends AppCompatActivity {
    private static final String TAG = "count2";

    protected TextView hiddenAnswer;
    protected TextView edAnswer;
    protected Button confirm;
    protected Button upButton;
    protected Button downButton;
    protected ImageView[] appleslist = new ImageView[10];
    private int totalVisibleApple;
    protected TextView timeLeft_textView;
    protected TextView score_textView;
    private int finalScore;
    CountDownTimer timerCounting2;

    public static final String COUNTING2_HIGHSCORE_KEY = "COUNTING2_HIGHSCORE_KEY";
    private SharedPreferences sharedPreferences;
    protected TextView highScore;

    protected void establish(){
        appleslist[0] = findViewById(R.id.counting2_ivApple);
        appleslist[1] = findViewById(R.id.counting2_ivApple2);
        appleslist[2] = findViewById(R.id.counting2_ivApple3);
        appleslist[3] = findViewById(R.id.counting2_ivApple4);
        appleslist[4] = findViewById(R.id.counting2_ivApple5);
        appleslist[5] = findViewById(R.id.counting2_ivApple6);
        appleslist[6] = findViewById(R.id.counting2_ivApple7);
        appleslist[7] = findViewById(R.id.counting2_ivApple8);
        appleslist[8] = findViewById(R.id.counting2_ivApple9);
        appleslist[9] = findViewById(R.id.counting2_ivApple10);
        hiddenAnswer = findViewById(R.id.counting2_hiddenAnswer);
        edAnswer = findViewById(R.id.counting2_tvAnswer);
        clearAnswer();
        confirm = findViewById(R.id.counting2_bConfirm);
        upButton = findViewById(R.id.counting2_bUp);
        downButton = findViewById(R.id.counting2_bDown);
        finalScore = 0;
        score_textView = findViewById(R.id.counting2_score);
        score_textView.setText("Score: -");
        timeLeft_textView = findViewById(R.id.counting2_timeLeft);
        highScore = findViewById(R.id.counting2_tvHighscore2);
    }

    protected void resetCounterApple(){
        totalVisibleApple = 0;
    }

    protected void setAppleVisible(ImageView a){
        Random rand = new Random();
        int random = rand.nextInt(2);
        if (random%2 == 0) {
            Log.d(TAG, "setAppleVisible: 0");
            a.setVisibility(View.INVISIBLE);
        } else if (random%2 == 1){
            Log.d(TAG, "setAppleVisible: 1");
            a.setVisibility(View.VISIBLE);
            totalVisibleApple +=1;
        }
        hiddenAnswer.setText(Integer.toString(totalVisibleApple));
    }

    protected void doScramble(){
        resetCounterApple();
        for (int i = 0; i<10; i++){
            setAppleVisible(appleslist[i]);
            Log.d(TAG, "onCreate: setapple" + i);
        }
    }


    protected boolean checkAnswer(int a, int b){
        return a==b;
    }

    protected void correctAnswer() {
        finalScore += 10;
        score_textView.setText("Score: " + finalScore);
    }

    protected void wrongAnswer() {
        finalScore -= 5;
        score_textView.setText("Score: " + finalScore);
    }

    protected boolean checkBlankAnswer(String a){
        return !a.equals("");
    }

    protected void clearAnswer(){
        edAnswer.setText("0");
    }

    protected void showSnackbar(View v, String text){
        Snackbar bar = Snackbar.make(v, text, Snackbar.LENGTH_LONG);
        bar.show();
    }

    protected void upButtonCount(){
        int a = Integer.parseInt(edAnswer.getText().toString())+1;
        edAnswer.setText(Integer.toString(a));
    }

    protected void downButtonCount(){
        int a = Integer.parseInt(edAnswer.getText().toString())-1;
        edAnswer.setText(Integer.toString(a));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timerCounting2.cancel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counting_topic2);

        establish();
        doScramble();
        sharedPreferences = getSharedPreferences("MySharedPreMain", Context.MODE_PRIVATE);
        if (sharedPreferences.contains(COUNTING2_HIGHSCORE_KEY)){
            highScore.setText(sharedPreferences.getString(COUNTING2_HIGHSCORE_KEY,""));
        }

        timerCounting2 = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                timeLeft_textView.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(COUNTING2_HIGHSCORE_KEY, Integer.toString(finalScore));
                editor.commit();

                timeLeft_textView.setText("done!");
                Intent intent = new Intent(getApplicationContext(), TestOverActivity.class);
                intent.putExtra("HighScore", Integer.toString(finalScore));
                startActivity(intent);
            }
        }.start();


        Log.d(TAG, "onCreate: visibleapple"+totalVisibleApple);

        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upButtonCount();
            }
        });

        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downButtonCount();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBlankAnswer(edAnswer.getText().toString())){
                    if (checkAnswer(Integer.parseInt(edAnswer.getText().toString()),Integer.parseInt(hiddenAnswer.getText().toString()))){
                        showSnackbar(v,"Correct");
                        correctAnswer();
                        doScramble();
                        clearAnswer();
                    }
                    else {
                        wrongAnswer();
                        showSnackbar(v, "False, The correct answer is " + hiddenAnswer.getText().toString());
                    }}
                else {
                    showSnackbar(v, "Blank Answer");
                }
            }
        });
    }
}
