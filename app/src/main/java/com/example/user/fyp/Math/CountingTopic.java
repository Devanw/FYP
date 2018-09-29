package com.example.user.fyp.Math;

import android.nfc.Tag;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fyp.R;

import java.util.Random;

public class CountingTopic extends AppCompatActivity {

    private static final String TAG = "count1";

    protected TextView hiddenAnswer;
    protected EditText edAnswer;
    protected Button confirm;
    protected ImageView[] appleslist = new ImageView[10];
    private int totalVisibleApple;

    protected void establish(){
        appleslist[0] = findViewById(R.id.counting1_ivApple);
        appleslist[1] = findViewById(R.id.counting1_ivApple2);
        appleslist[2] = findViewById(R.id.counting1_ivApple3);
        appleslist[3] = findViewById(R.id.counting1_ivApple4);
        appleslist[4] = findViewById(R.id.counting1_ivApple5);
        appleslist[5] = findViewById(R.id.counting1_ivApple6);
        appleslist[6] = findViewById(R.id.counting1_ivApple7);
        appleslist[7] = findViewById(R.id.counting1_ivApple8);
        appleslist[8] = findViewById(R.id.counting1_ivApple9);
        appleslist[9] = findViewById(R.id.counting1_ivApple10);
        hiddenAnswer = findViewById(R.id.counting1_hiddenAnswer);
        edAnswer = findViewById(R.id.counting1_etAnswer);
        confirm = findViewById(R.id.counting1_bConfirm);
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

    protected boolean checkBlankAnswer(String a){
        return !a.equals("");
    }

    protected void clearAnswer(){
        edAnswer.setText("");
    }

    protected void showSnackbar(View v, String text){
        Snackbar bar = Snackbar.make(v, text, Snackbar.LENGTH_LONG);
        bar.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counting_topic);

        establish();

        doScramble();


        Log.d(TAG, "onCreate: visibleapple"+totalVisibleApple);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBlankAnswer(edAnswer.getText().toString())){
                    if (checkAnswer(Integer.parseInt(edAnswer.getText().toString()),Integer.parseInt(hiddenAnswer.getText().toString()))){
                        showSnackbar(v,"Correct");
                        doScramble();
                        clearAnswer();
                    }
                    else {
                        showSnackbar(v, "False, The correct answer is " + hiddenAnswer.getText().toString());
                    }}
                else {
                    showSnackbar(v, "Blank Answer");
                }
            }
        });

    }
}
