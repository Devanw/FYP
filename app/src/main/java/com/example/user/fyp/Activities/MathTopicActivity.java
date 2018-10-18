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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_topic);
        final Button buttonSummation1 = findViewById(R.id.mathTopicActivity_bSummation1);
        buttonSummation1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), Summation1.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });

        final Button buttonCounting = findViewById(R.id.mathTopicActivity_bCounting1);
        buttonCounting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), CountingTopic.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });

        final Button buttonCounting2 = findViewById(R.id.mathTopicActivity_bCounting2);
        buttonCounting2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), CountingTopic2.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });

        final Button buttonSubtraction1 = findViewById(R.id.mathTopicActivity_bSubtraction1);
        buttonSubtraction1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), Subtraction1.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });

        final Button buttonGeo = findViewById(R.id.mathTopicActivity_bGeometry1);
        buttonGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), Geometry1.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });

        final Button buttonSCounting = findViewById(R.id.mathTopicActivity_bSCounting);
        buttonSCounting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), StudyCounting.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });

        final Button buttonSGeo = findViewById(R.id.mathTopicActivity_bSGeometry);
        buttonSGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), StudyGeometry.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });

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

        Spinner spinnerStudyOrTest =  findViewById(R.id.mathTopicActivity_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerFill, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStudyOrTest.setAdapter(adapter);
        spinnerStudyOrTest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
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
                else if (position == 1){
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
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
