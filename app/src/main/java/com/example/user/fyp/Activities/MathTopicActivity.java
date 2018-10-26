package com.example.user.fyp.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.user.fyp.Math.Challenge.CountingTopic;
import com.example.user.fyp.Math.Challenge.CountingTopic2;
import com.example.user.fyp.Math.Challenge.Geometry1;
import com.example.user.fyp.Math.Study.StudyCounting;
import com.example.user.fyp.Math.Study.StudyGeometry;
import com.example.user.fyp.Math.Challenge.Subtraction1;
import com.example.user.fyp.Math.Challenge.Summation1;
import com.example.user.fyp.Math.Study.StudySummation;
import com.example.user.fyp.R;

public class MathTopicActivity extends AppCompatActivity {

    private static final String TAG = "MathTopic";
    public static final String MATHTOPIC_SPINNER_KEY = "MATHTOPIC_SPINNER_KEY";

    CountingTopic count1;
    CountingTopic2 count2;
    Summation1 summ1;
    Subtraction1 subt1;
    Geometry1 geom1;

    Button buttonCounting;
    Button buttonCounting2;
    Button buttonSummation1;
    Button buttonSubtraction1;
    Button buttonGeo;
    Button buttonSCounting;
    Button buttonSGeo;
    Button buttonSSumm;
    Spinner spinnerStudyOrChallenge;
    ArrayAdapter<CharSequence> adapter;

    TextView highScoreTag;
    TextView highScore1;
    TextView highScore2;
    TextView highScore3;
    TextView highScore4;
    TextView highScore5;

    SharedPreferences sharedPreferences;

    protected void establish(){
        buttonCounting = findViewById(R.id.mathTopicActivity_bCounting1);
        buttonCounting2 = findViewById(R.id.mathTopicActivity_bCounting2);
        buttonSummation1 = findViewById(R.id.mathTopicActivity_bSummation1);
        buttonSubtraction1 = findViewById(R.id.mathTopicActivity_bSubtraction1);
        buttonGeo = findViewById(R.id.mathTopicActivity_bGeometry1);
        buttonSCounting = findViewById(R.id.mathTopicActivity_bSCounting);
        buttonSGeo = findViewById(R.id.mathTopicActivity_bSGeometry);
        buttonSSumm = findViewById(R.id.mathTopicActivity_bSSummation);
        spinnerStudyOrChallenge =  findViewById(R.id.mathTopicActivity_spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.spinnerFill, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStudyOrChallenge.setAdapter(adapter);

        try {
            sharedPreferences = getSharedPreferences("MySharedPreMain", Context.MODE_PRIVATE);
            spinnerStudyOrChallenge.setSelection(sharedPreferences.getInt(MATHTOPIC_SPINNER_KEY, 0));
            Log.d(TAG, "establish: gamauuuuuu");
        }
        catch (Exception e){
            Log.d(TAG, "establish: gamau");
        }
        highScoreTag = findViewById(R.id.mathTopicActivity_tvHighScore1);
        highScore1 = findViewById(R.id.mathTopicActivity_tvHighScore2);
        highScore2 = findViewById(R.id.mathTopicActivity_tvHighScore3);
        highScore3 = findViewById(R.id.mathTopicActivity_tvHighScore4);
        highScore4 = findViewById(R.id.mathTopicActivity_tvHighScore5);
        highScore5 = findViewById(R.id.mathTopicActivity_tvHighScore6);
    }

    protected void setChallenge(){
        buttonCounting.setVisibility(View.VISIBLE);
        buttonCounting.setClickable(true);
        buttonCounting2.setVisibility(View.VISIBLE);
        buttonCounting2.setClickable(true);
        buttonGeo.setVisibility(View.VISIBLE);
        buttonGeo.setClickable(true);
        buttonSummation1.setVisibility(View.VISIBLE);
        buttonSummation1.setClickable(true);
        buttonSubtraction1.setVisibility(View.VISIBLE);
        buttonSubtraction1.setClickable(true);
        buttonSCounting.setVisibility(View.INVISIBLE);
        buttonSCounting.setClickable(false);
        buttonSGeo.setVisibility(View.INVISIBLE);
        buttonSGeo.setClickable(false);
        buttonSSumm.setVisibility(View.INVISIBLE);
        buttonSSumm.setClickable(false);

        highScoreTag.setVisibility(View.VISIBLE);
        highScore1.setVisibility(View.VISIBLE);
        highScore2.setVisibility(View.VISIBLE);
        highScore3.setVisibility(View.VISIBLE);
        highScore4.setVisibility(View.VISIBLE);
        highScore5.setVisibility(View.VISIBLE);
    }

    protected void setStudy(){
        buttonCounting.setVisibility(View.INVISIBLE);
        buttonCounting.setClickable(false);
        buttonCounting2.setVisibility(View.INVISIBLE);
        buttonCounting2.setClickable(false);
        buttonGeo.setVisibility(View.INVISIBLE);
        buttonGeo.setClickable(false);
        buttonSummation1.setVisibility(View.INVISIBLE);
        buttonSummation1.setClickable(false);
        buttonSubtraction1.setVisibility(View.INVISIBLE);
        buttonSubtraction1.setClickable(false);
        buttonSCounting.setVisibility(View.VISIBLE);
        buttonSCounting.setClickable(true);
        buttonSGeo.setVisibility(View.VISIBLE);
        buttonSGeo.setClickable(true);
        buttonSSumm.setVisibility(View.VISIBLE);
        buttonSSumm.setClickable(true);

        highScoreTag.setVisibility(View.INVISIBLE);
        highScore1.setVisibility(View.INVISIBLE);
        highScore2.setVisibility(View.INVISIBLE);
        highScore3.setVisibility(View.INVISIBLE);
        highScore4.setVisibility(View.INVISIBLE);
        highScore5.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);// animation
    }

    protected void setSpinner0(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(MATHTOPIC_SPINNER_KEY, 0);
        editor.commit();
        Log.d(TAG, "setSpinner0: gamau");
    }

    protected void setSpinner1(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(MATHTOPIC_SPINNER_KEY, 1);
        editor.commit();
        Log.d(TAG, "setSpinner1: gamau");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_topic);

        establish();

        sharedPreferences = getSharedPreferences("MySharedPreMain", Context.MODE_PRIVATE);
        if (sharedPreferences.contains(count1.COUNTING11_HIGHSCORE_KEY)){
            highScore1.setText(Integer.toString(sharedPreferences.getInt(count1.COUNTING11_HIGHSCORE_KEY,0)));
        }
        if (sharedPreferences.contains(count2.COUNTING2_HIGHSCORE_KEY)){
            highScore2.setText(Integer.toString(sharedPreferences.getInt(count2.COUNTING2_HIGHSCORE_KEY,0)));
        }
        if (sharedPreferences.contains(summ1.SUMMATION1_HIGHSCORE_KEY)){
            highScore3.setText(Integer.toString(sharedPreferences.getInt(summ1.SUMMATION1_HIGHSCORE_KEY,0)));
        }
        if (sharedPreferences.contains(subt1.SUBTRACTION1_HIGHSCORE_KEY)){
            highScore4.setText(Integer.toString(sharedPreferences.getInt(subt1.SUBTRACTION1_HIGHSCORE_KEY,0)));
        }
        if (sharedPreferences.contains(geom1.GEOMETRY1_HIGHSCORE_KEY)){
            highScore5.setText(Integer.toString(sharedPreferences.getInt(geom1.GEOMETRY1_HIGHSCORE_KEY,0)));
        }

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String value = preferences.getString("", "defaultValue");

        buttonSummation1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), Summation1.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);// animation
            }
        });

        buttonCounting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), CountingTopic.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);// animation
            }
        });


        buttonCounting2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), CountingTopic2.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);// animation
            }
        });

        buttonSubtraction1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), Subtraction1.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);// animation
            }
        });

        buttonGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), Geometry1.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);// animation
            }
        });

        buttonSCounting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), StudyCounting.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);// animation
            }
        });

        buttonSGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), StudyGeometry.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);// animation
            }
        });

        buttonSSumm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), StudySummation.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);// animation
            }
        });

        spinnerStudyOrChallenge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    setSpinner0();
                    setStudy();
                }
                else if (position == 1){
                    setSpinner1();
                    setChallenge();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
