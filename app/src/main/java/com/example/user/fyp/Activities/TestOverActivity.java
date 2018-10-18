package com.example.user.fyp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.fyp.R;

import org.w3c.dom.Text;

public class TestOverActivity extends AppCompatActivity {

    TextView highScore;

    protected void establish(){
        highScore = findViewById(R.id.testOver_score);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_over);
        establish();
        String intentScore = getIntent().getExtras().getString("HighScore");
        highScore.setText(intentScore);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MathTopicActivity.class);
        startActivity(intent);
   }
}
