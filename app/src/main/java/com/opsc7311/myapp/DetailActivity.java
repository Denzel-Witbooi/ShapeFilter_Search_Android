package com.opsc7311.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    Shape selectedShape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //1. Get our shape
        getSelectedShape();

        //2. Set values
        setValues();
    }

    private void getSelectedShape() {
        Intent previousIntent = getIntent();
        // make sure its the same name "id" as in MainAct class putExtra method
        String parsedStringID = previousIntent.getStringExtra("id");
        selectedShape = MainActivity.shapeList.get(Integer.valueOf(parsedStringID));
    }

    private void setValues() {
        TextView tv = (TextView) findViewById(R.id.shapeName);
        ImageView iv = (ImageView) findViewById(R.id.shapeImage);

        tv.setText(selectedShape.getName());
        iv.setImageResource(selectedShape.getImage());
    }
}