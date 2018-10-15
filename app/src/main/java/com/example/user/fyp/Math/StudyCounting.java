package com.example.user.fyp.Math;

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

public class StudyCounting extends AppCompatActivity {

    private static final String TAG = "sCount";

    protected Button next;
    protected Button back;
    protected ImageView[] appleslist = new ImageView[20];
    protected String[] numberName;
    protected TextView x;
    protected int totalNumber;

    protected void establish(){
        appleslist[0] = findViewById(R.id.sCounting_ivApple);
        appleslist[1] = findViewById(R.id.sCounting_ivApple2);
        appleslist[2] = findViewById(R.id.sCounting_ivApple3);
        appleslist[3] = findViewById(R.id.sCounting_ivApple4);
        appleslist[4] = findViewById(R.id.sCounting_ivApple5);
        appleslist[5] = findViewById(R.id.sCounting_ivApple6);
        appleslist[6] = findViewById(R.id.sCounting_ivApple7);
        appleslist[7] = findViewById(R.id.sCounting_ivApple8);
        appleslist[8] = findViewById(R.id.sCounting_ivApple9);
        appleslist[9] = findViewById(R.id.sCounting_ivApple10);
        appleslist[10] = findViewById(R.id.sCounting_ivApple11);
        appleslist[11] = findViewById(R.id.sCounting_ivApple12);
        appleslist[12] = findViewById(R.id.sCounting_ivApple13);
        appleslist[13] = findViewById(R.id.sCounting_ivApple14);
        appleslist[14] = findViewById(R.id.sCounting_ivApple15);
        appleslist[15] = findViewById(R.id.sCounting_ivApple16);
        appleslist[16] = findViewById(R.id.sCounting_ivApple17);
        appleslist[17] = findViewById(R.id.sCounting_ivApple18);
        appleslist[18] = findViewById(R.id.sCounting_ivApple19);
        appleslist[19] = findViewById(R.id.sCounting_ivApple20);

        next = findViewById(R.id.sCounting_bNext);
        back = findViewById(R.id.sCounting_bBack);
        back.setClickable(false);
        back.setVisibility(View.INVISIBLE);

        x = findViewById(R.id.sCounting_tvX);
        numberName = getResources().getStringArray(R.array.countNumber);
        totalNumber = 0;
    }

    protected void resetCounterApple(){
        totalNumber = 0;
    }

    protected void addApple(){
        if (totalNumber>=19){
            next.setClickable(false);
            next.setVisibility(View.INVISIBLE);
        }
        if (totalNumber>=0){
            back.setClickable(true);
            back.setVisibility(View.VISIBLE);
        }
        appleslist[totalNumber].setVisibility(View.VISIBLE);
        totalNumber++;
        x.setText(Integer.toString(totalNumber));
        Log.d(TAG, "addApple: totalnum"+totalNumber);
    }

    protected void reduceApple(){
        if (totalNumber<=1){
            back.setClickable(false);
            back.setVisibility(View.INVISIBLE);
        }
        if (totalNumber<=20){
            next.setClickable(true);
            next.setVisibility(View.VISIBLE);
        }
        totalNumber--;
        appleslist[totalNumber].setVisibility(View.INVISIBLE);
        x.setText(Integer.toString(totalNumber));
        Log.d(TAG, "addApple: totalnum"+totalNumber);
    }

    protected void setAppleInvisible(ImageView a){
        a.setVisibility(View.INVISIBLE);
    }


    protected void doScramble(){
        resetCounterApple();
        for (int i = 0; i<20; i++){
            setAppleInvisible(appleslist[i]);
            Log.d(TAG, "onCreate: setapple" + i);
        }
        x.setText(Integer.toString(totalNumber));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_counting);

        establish();

        doScramble();

        x.setClickable(true);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Integer.parseInt(x.getText().toString());
                    x.setText(numberName[totalNumber]);
                }
                catch (Exception e){
                    x.setText(Integer.toString(totalNumber));
                }
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addApple();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reduceApple();
            }
        });

    }
}
