package com.example.user.fyp.Math;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometry1);
        establish();
        clearAns();
        randomize();

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
                if (Integer.parseInt(actualAns.getText().toString()) == Integer.parseInt(hiddenAns.getText().toString())){
                    Toast.makeText(Geometry1.this, "CORRECT", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Geometry1.this, "INCORRECT", Toast.LENGTH_SHORT).show();
                }
                randomize();
                clearAns();
            }
        });
    }

}
