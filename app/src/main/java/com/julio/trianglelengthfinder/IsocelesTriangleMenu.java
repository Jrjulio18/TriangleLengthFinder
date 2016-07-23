package com.julio.trianglelengthfinder;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by ACER on 7/18/2016.
 */
public class IsocelesTriangleMenu extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equilateral_triangle_menu);
    }

    public void sendMessage(View view) {
        switch (view.getId()) {

            case R.id.isocelesHeightButton: {
                EditText heightText = (EditText) findViewById(R.id.heightData);
                Double heightData = Double.parseDouble(heightText.getText().toString());

                //Begin Calculations

                Double base = heightData/2;
                Double result = Math.sqrt(Math.pow(heightData,2) - Math.pow(base,2));
                TextView textViewResult = (TextView) findViewById(R.id.heightResults);
                DecimalFormat df = new DecimalFormat("#.####");
                Double trimDouble = Double.parseDouble(df.format(result));
                textViewResult.setText(Double.toString(trimDouble));

            }
        }
    }
}
