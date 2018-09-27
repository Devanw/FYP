package com.example.user.fyp.Math;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.fyp.R;

import org.w3c.dom.Text;

import java.util.Random;

public class Summation1 extends AppCompatActivity {

    private static final String TAG = "Summ1";
    protected TextView x;
    protected TextView y;
    protected EditText c;
    protected TextView answer_textView;
    protected TextView timeLeft_textView;
    protected TextView score_textView;
    protected Button confirm;
    private int finalScore;

    protected void establish (){
        x = findViewById(R.id.summation1_firstNumber);
        y = findViewById(R.id.summation1_secondNumber);
        c = findViewById(R.id.summation1_answer);
        answer_textView = findViewById(R.id.summation1_hiddenAnswer);
        confirm = findViewById(R.id.summation1_buttonConfirm);
        timeLeft_textView = findViewById(R.id.summation1_timeLeft);
        score_textView = findViewById(R.id.summation1_score);
        score_textView.setText("Score: -");
        finalScore = 0;
    }

    protected void randomise(){
        int a,b,answer;
        Random rand = new Random();
        a = rand.nextInt(10);
        b = rand.nextInt(10);
        answer = a+b;

        x.setText(Integer.toString(a));
        y.setText(Integer.toString(b));
        answer_textView.setText(Integer.toString(answer));
    }

    protected boolean checkAnswer(int a, int b){
        return a==b;
    }

    protected boolean checkBlankAnswer(String a){
        return !a.equals("");
    }

    protected void clearAnswer(){
        c.setText("");
    }

    protected void showSnackbar(View v, String text){
        Snackbar bar = Snackbar.make(v, text, Snackbar.LENGTH_LONG);
        bar.show();
    }

    protected void correctAnswer(){
        finalScore+=10;
        score_textView.setText("Score: " + finalScore);
    }

    protected void wrongAnswer(){
        finalScore-=5;
        score_textView.setText("Score: " + finalScore);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summation1);
        establish();
        randomise();

        new CountDownTimer(30000,1000){
            public void onTick(long millisUntilFinished) {
                timeLeft_textView.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timeLeft_textView.setText("done!");
            }
        }.start();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBlankAnswer(c.getText().toString())){
                    if (checkAnswer(Integer.parseInt(c.getText().toString()),Integer.parseInt(answer_textView.getText().toString()))){
                    showSnackbar(v,"Correct");
                    correctAnswer();
                    randomise();
                    clearAnswer();
                }
                else {
                    showSnackbar(v, "False, The correct answer is " + answer_textView.getText().toString());
                    wrongAnswer();
                }}
                else {
                    showSnackbar(v, "Blank Answer");
                }
            }
        });

    }


}
