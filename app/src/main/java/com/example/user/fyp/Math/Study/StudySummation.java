package com.example.user.fyp.Math.Study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fyp.Activities.MathTopicActivity;
import com.example.user.fyp.R;

public class StudySummation extends AppCompatActivity {
    private static final String TAG = "StartActivity";

    protected Button aUp;
    protected Button aDown;
    protected Button bUp;
    protected Button bDown;

    protected ImageView[] appleslist = new ImageView[10];
    protected ImageView[] appleslistA = new ImageView[6];
    protected ImageView[] appleslistB = new ImageView[4];

    protected TextView a;
    protected TextView b;
    protected TextView x;
    protected int totalNumber;
    protected int firstNumber;
    protected int secondNumber;

    protected void establish(){
        appleslist[0] = findViewById(R.id.sSumm_ivApple);
        appleslist[1] = findViewById(R.id.sSumm_ivApple2);
        appleslist[2] = findViewById(R.id.sSumm_ivApple3);
        appleslist[3] = findViewById(R.id.sSumm_ivApple4);
        appleslist[4] = findViewById(R.id.sSumm_ivApple5);
        appleslist[5] = findViewById(R.id.sSumm_ivApple6);
        appleslist[6] = findViewById(R.id.sSumm_ivApple7);
        appleslist[7] = findViewById(R.id.sSumm_ivApple8);
        appleslist[8] = findViewById(R.id.sSumm_ivApple9);
        appleslist[9] = findViewById(R.id.sSumm_ivApple10);

        appleslistA[0] = findViewById(R.id.sSumm_iv1);
        appleslistA[1] = findViewById(R.id.sSumm_iv2);
        appleslistA[2] = findViewById(R.id.sSumm_iv3);
        appleslistA[3] = findViewById(R.id.sSumm_iv4);
        appleslistA[4] = findViewById(R.id.sSumm_iv5);
        appleslistA[5] = findViewById(R.id.sSumm_iv6);

        appleslistB[0] = findViewById(R.id.sSumm_iv7);
        appleslistB[1] = findViewById(R.id.sSumm_iv8);
        appleslistB[2] = findViewById(R.id.sSumm_iv9);
        appleslistB[3] = findViewById(R.id.sSumm_iv10);

        aUp = findViewById(R.id.sSumm_bUp);
        bUp = findViewById(R.id.sSumm_bUp3);

        aDown = findViewById(R.id.sSumm_bDown2);
        bDown = findViewById(R.id.sSumm_bDown4);

        a = findViewById(R.id.sSumm_tv3);
        b = findViewById(R.id.sSumm_tv6);

        x = findViewById(R.id.sSumm_tvX);
        totalNumber = 0;
        firstNumber = 0;
        secondNumber = 0;
    }

    protected void resetCounterApple(){
        totalNumber = 0;
    }

    protected void checkTogetherPlus(){
        totalNumber = firstNumber + secondNumber;
        appleslist[totalNumber-1].setVisibility(View.VISIBLE);;
        x.setText(Integer.toString(totalNumber));
    }

    protected void checkTogetherMinus(){
        totalNumber = firstNumber + secondNumber;
        appleslist[totalNumber].setVisibility(View.INVISIBLE);;
        x.setText(Integer.toString(totalNumber));
    }

    protected void addAppleA(){
        if (firstNumber>=5){
            aUp.setClickable(false);
            aUp.setVisibility(View.INVISIBLE);
        }
        if (firstNumber>=0){
            aDown.setClickable(true);
            aDown.setVisibility(View.VISIBLE);
        }
        appleslistA[firstNumber].setVisibility(View.VISIBLE);
        firstNumber++;
        a.setText(Integer.toString(firstNumber));
        checkTogetherPlus();
        Log.d(TAG, "addApple: totalnum"+firstNumber);
    }

    protected void reduceAppleA(){
        if (firstNumber<=1){
            aDown.setClickable(false);
            aDown.setVisibility(View.INVISIBLE);
        }
        if (firstNumber<=6){
            aUp.setClickable(true);
            aUp.setVisibility(View.VISIBLE);
        }
        firstNumber--;
        appleslistA[firstNumber].setVisibility(View.INVISIBLE);
        a.setText(Integer.toString(firstNumber));
        checkTogetherMinus();
        Log.d(TAG, "addApple: totalnum"+firstNumber);
    }

    protected void addAppleB(){
        if (secondNumber>=3){
            bUp.setClickable(false);
            bUp.setVisibility(View.INVISIBLE);
        }
        if (secondNumber>=0){
            bDown.setClickable(true);
            bDown.setVisibility(View.VISIBLE);
        }
        appleslistB[secondNumber].setVisibility(View.VISIBLE);
        secondNumber++;
        b.setText(Integer.toString(secondNumber));
        checkTogetherPlus();
        Log.d(TAG, "addApple: totalnum"+secondNumber);
    }

    protected void reduceAppleB(){
        if (secondNumber<=1){
            bDown.setClickable(false);
            bDown.setVisibility(View.INVISIBLE);
        }
        if (secondNumber<=4){
            bUp.setClickable(true);
            bUp.setVisibility(View.VISIBLE);
        }
        secondNumber--;
        appleslistB[secondNumber].setVisibility(View.INVISIBLE);
        b.setText(Integer.toString(secondNumber));
        checkTogetherMinus();
        Log.d(TAG, "addApple: totalnum"+secondNumber);
    }

    protected void setAppleInvisible(ImageView a){
        a.setVisibility(View.INVISIBLE);
    }


    protected void doScramble(){
        resetCounterApple();
        for (int i = 0; i<10; i++){
            setAppleInvisible(appleslist[i]);
            Log.d(TAG, "onCreate: setapple" + i);
        }
        for (int j = 0; j<6; j++){
            setAppleInvisible(appleslistA[j]);
            Log.d(TAG, "doScramble: setapple"+ j);
        }
        for (int k = 0; k<4; k++){
            setAppleInvisible(appleslistB[k]);
            Log.d(TAG, "doScramble: setapplee"+ k);
        }
        x.setText(Integer.toString(totalNumber));
        aDown.setVisibility(View.INVISIBLE);
        bDown.setVisibility(View.INVISIBLE);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),MathTopicActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);// animation
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_summation);
        establish();
        doScramble();

        aUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppleA();
            }
        });

        aDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reduceAppleA();
            }
        });

        bUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppleB();
            }
        });

        bDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reduceAppleB();
            }
        });

    }
}
