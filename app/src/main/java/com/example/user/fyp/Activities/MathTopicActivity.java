package com.example.user.fyp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.user.fyp.Math.CountingTopic;
import com.example.user.fyp.Math.CountingTopic2;
import com.example.user.fyp.Math.Geometry1;
import com.example.user.fyp.Math.StudyCounting;
import com.example.user.fyp.Math.StudyGeometry;
import com.example.user.fyp.Math.Subtraction1;
import com.example.user.fyp.Math.Summation1;
import com.example.user.fyp.R;

public class MathTopicActivity extends AppCompatActivity {

    private static final String TAG = "MathTopic";

    Button buttonCounting;
    Button buttonCounting2;
    Button buttonSummation1;
    Button buttonSubtraction1;
    Button buttonGeo;
    Button buttonSCounting;
    Button buttonSGeo;
    Spinner spinnerStudyOrChallenge;
    ArrayAdapter<CharSequence> adapter;

    protected void establish(){
        buttonCounting = findViewById(R.id.mathTopicActivity_bCounting1);
        buttonCounting2 = findViewById(R.id.mathTopicActivity_bCounting2);
        buttonSummation1 = findViewById(R.id.mathTopicActivity_bSummation1);
        buttonSubtraction1 = findViewById(R.id.mathTopicActivity_bSubtraction1);
        buttonGeo = findViewById(R.id.mathTopicActivity_bGeometry1);
        buttonSCounting = findViewById(R.id.mathTopicActivity_bSCounting);
        buttonSGeo = findViewById(R.id.mathTopicActivity_bSGeometry);
        spinnerStudyOrChallenge =  findViewById(R.id.mathTopicActivity_spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.spinnerFill, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStudyOrChallenge.setAdapter(adapter);
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_topic);

        establish();

        buttonSummation1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), Summation1.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });

        buttonCounting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), CountingTopic.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });


        buttonCounting2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), CountingTopic2.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });

        buttonSubtraction1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), Subtraction1.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });

        buttonGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), Geometry1.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });

        buttonSCounting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), StudyCounting.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });

        buttonSGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), StudyGeometry.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });

        spinnerStudyOrChallenge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    setStudy();
                }
                else if (position == 1){
                    setChallenge();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
