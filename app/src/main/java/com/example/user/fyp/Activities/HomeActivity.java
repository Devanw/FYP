package com.example.user.fyp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.user.fyp.Math.MathTopicActivity;
import com.example.user.fyp.R;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG ="Home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button button1 = findViewById(R.id.homeActivity_mathButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), MathTopicActivity.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });

        Button buttonSchedule = findViewById(R.id.homeActivity_schedulebutton);
        buttonSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), SchedulerActivity.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });
    }
}
