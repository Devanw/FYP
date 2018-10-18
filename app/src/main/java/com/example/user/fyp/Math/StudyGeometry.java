package com.example.user.fyp.Math;

import android.content.Intent;
import android.content.res.TypedArray;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fyp.Activities.MathTopicActivity;
import com.example.user.fyp.R;

import org.w3c.dom.Text;

public class StudyGeometry extends AppCompatActivity {

    private static final String TAG = "sGeo";

    protected Button next;
    protected Button back;
    protected TypedArray geoList;
    protected String[] geoName;
    protected CharSequence[] geoDef;
    protected ImageView geoImage;
    protected TextView sGeoDesc;
    protected TextView sGeoName;
    protected int geoNum;

    protected void establish(){
        geoList = getResources().obtainTypedArray(R.array.geometryPic);
        geoName = getResources().getStringArray(R.array.geometryName);
        geoDef = getResources().getTextArray(R.array.geometryDefinition);
        geoNum = 0;

        next = findViewById(R.id.sGeometry_bNext);
        back = findViewById(R.id.sGeometry_bBack);

        sGeoDesc = findViewById(R.id.sGeometry_tvDesc);
        sGeoName = findViewById(R.id.sGeometry_tvName);
        geoImage = findViewById(R.id.sGeometry_ivShape);
    }

    protected void setDef(int a){
        geoImage.setImageResource(geoList.getResourceId(a,1));
        sGeoDesc.setText(geoDef[a]);
        sGeoName.setText(geoName[a]);
    }


    protected void addShape(){
        if (geoNum>=1){
            next.setClickable(false);
            next.setVisibility(View.INVISIBLE);
        }
        if (geoNum>=0){
            back.setClickable(true);
            back.setVisibility(View.VISIBLE);
        }
        geoNum++;
        setDef(geoNum);
        Log.d(TAG, "addShape: totalnum"+geoNum);
    }

    protected void reduceShape(){
        if (geoNum<=1){
            back.setClickable(false);
            back.setVisibility(View.INVISIBLE);
        }
        if (geoNum<=2){
            next.setClickable(true);
            next.setVisibility(View.VISIBLE);
        }
        geoNum--;
        setDef(geoNum);
        Log.d(TAG, "addShape: totalnum"+geoNum);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),MathTopicActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_geometry);

        establish();
        setDef(0);
        back.setClickable(false);
        back.setVisibility(View.INVISIBLE);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addShape();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reduceShape();
            }
        });

    }
}
