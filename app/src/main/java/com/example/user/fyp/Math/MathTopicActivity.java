package com.example.user.fyp.Math;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.user.fyp.R;

public class MathTopicActivity extends AppCompatActivity {

    private static final String TAG = "MathTopic";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_topic);
        Button buttonSummation = findViewById(R.id.button10);
        buttonSummation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), Summation1.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });
    }
}
