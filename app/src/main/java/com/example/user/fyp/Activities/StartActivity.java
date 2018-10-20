package com.example.user.fyp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.user.fyp.Activities.HomeActivity;
import com.example.user.fyp.R;

public class StartActivity extends AppCompatActivity {
    private static final String TAG = "StartActivity";

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button button1 = findViewById(R.id.startActivity_startButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: start");
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                Log.d(TAG, "onClick: before intent");
                startActivity(intent);
            }
        });
    }
}
