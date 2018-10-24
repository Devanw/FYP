package com.example.user.fyp.Math.Challenge;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.fyp.Activities.MathTopicActivity;
import com.example.user.fyp.Activities.TestOverActivity;
import com.example.user.fyp.R;

import java.util.Random;

public class Geometry1 extends AppCompatActivity {

    protected TypedArray geometryPic;
    protected String [] geometryNameArry;
    protected ImageView shapeImage;
    protected LinearLayout first, second, third;
    protected Button confirmAnswerGeo;
    protected TextView hiddenAns;
    protected TextView actualAns;
    protected TextView timeLeft_textView;
    protected TextView score_textView;
    private int finalScore;
    CountDownTimer timerGEOMETRY;

    public static final String GEOMETRY1_HIGHSCORE_KEY = "GEOMETRY1_HIGHSCORE_KEY";
    private SharedPreferences sharedPreferences;
    protected TextView highScore;


    protected void establish(){
        shapeImage = findViewById(R.id.geometry1_ivShape);
        first = findViewById(R.id.linearA);
        second = findViewById(R.id.linearB);
        third = findViewById(R.id.linearC);
        confirmAnswerGeo = findViewById(R.id.geometry1_bConfirm);
        hiddenAns = findViewById(R.id.geometry1_hiddenGeoAns);
        actualAns = findViewById(R.id.geometry1_actualHiddenAns);
        geometryPic = getResources().obtainTypedArray(R.array.geometryPic);
        geometryNameArry = getResources().getStringArray(R.array.geometryName);
        finalScore = 0;
        score_textView = findViewById(R.id.geometry1_score);
        score_textView.setText("Score: -");
        timeLeft_textView = findViewById(R.id.geometry1_timeLeft);
        highScore = findViewById(R.id.geometry1_tvHighscore2);
    }

    protected void randomize(){
        Random rand = new Random();
        int a = rand.nextInt(3);
        Log.d("randompic", "onCreate: "+a);
        actualAns.setText(Integer.toString(a));
        shapeImage.setImageResource(geometryPic.getResourceId(a,0));
    }

    protected void clearAns(){
        first.setBackgroundResource(R.color.whitee);
        second.setBackgroundResource(R.color.whitee);
        third.setBackgroundResource(R.color.whitee);
        hiddenAns.setText("");
    }

    protected boolean checkAnswer(String a, String b){
        return (Integer.parseInt(a) == Integer.parseInt(b));
    }

    protected void correctAnswer() {
        finalScore += 10;
        score_textView.setText("Score: " + finalScore);
    }

    protected void wrongAnswer() {
        finalScore -= 5;
        score_textView.setText("Score: " + finalScore);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timerGEOMETRY.cancel();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),MathTopicActivity.class);
        startActivity(intent);
    }

    protected void showSnackbar(View v, String text){
        Snackbar bar = Snackbar.make(v, text, Snackbar.LENGTH_LONG);
        bar.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometry1);
        establish();
        clearAns();
        randomize();

        sharedPreferences = getSharedPreferences("MySharedPreMain", Context.MODE_PRIVATE);
        if (sharedPreferences.contains(GEOMETRY1_HIGHSCORE_KEY)){
            highScore.setText(Integer.toString(sharedPreferences.getInt(GEOMETRY1_HIGHSCORE_KEY,0)));
        }

        timerGEOMETRY = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                timeLeft_textView.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                try {
                    if (sharedPreferences.getInt(GEOMETRY1_HIGHSCORE_KEY, 0) < finalScore) {
                        editor.putInt(GEOMETRY1_HIGHSCORE_KEY, finalScore);
                        editor.commit();
                    }
                }
                catch (Exception e){
                    editor.putInt(GEOMETRY1_HIGHSCORE_KEY, finalScore);
                    editor.commit();
                }

                timeLeft_textView.setText("done!");
                Intent intent = new Intent(getApplicationContext(), TestOverActivity.class);
                intent.putExtra("HighScore", Integer.toString(finalScore));
                startActivity(intent);
            }
        }.start();

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first.setBackgroundResource(R.color.colorAccent);
                second.setBackgroundResource(R.color.whitee);
                third.setBackgroundResource(R.color.whitee);
                hiddenAns.setText(Integer.toString(0));
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first.setBackgroundResource(R.color.whitee);
                second.setBackgroundResource(R.color.colorAccent);
                third.setBackgroundResource(R.color.whitee);
                hiddenAns.setText(Integer.toString(1));
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first.setBackgroundResource(R.color.whitee);
                second.setBackgroundResource(R.color.whitee);
                third.setBackgroundResource(R.color.colorAccent);
                hiddenAns.setText(Integer.toString(2));
            }
        });

        confirmAnswerGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (checkAnswer(actualAns.getText().toString(), hiddenAns.getText().toString())) {
                        showSnackbar(v,"Correct!!");
                        correctAnswer();
                        randomize();
                    } else {
                        wrongAnswer();
                        showSnackbar(v, "Incorrect, Try Again\nYou Can!!!");
                    }
                }
                catch (Exception e) {
                    showSnackbar(v, "Blank Answer");
                }
                clearAns();
            }
        });
    }

}
