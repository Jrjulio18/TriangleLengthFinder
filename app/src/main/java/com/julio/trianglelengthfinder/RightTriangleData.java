package com.julio.trianglelengthfinder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by ACER on 7/15/2016.
 */
public class RightTriangleData extends AppCompatActivity {
    static int chooser = 0;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.right_triangle_data);

        Bundle extras = getIntent().getExtras();

        String key = extras.getString("key");
        if (key.equals("BF")) {
            TextView hypoText = (TextView) findViewById(R.id.firstText);
            hypoText.setText("Hypotenuse:");
            TextView heightText = (TextView) findViewById(R.id.secondText);
            heightText.setText("Height:");
            chooser =1;

            //The key argument here must match that used in the other activity
        }
//Second Option
        if (key.equals("HF")) {
            TextView hypoText = (TextView) findViewById(R.id.firstText);
            hypoText.setText("Hypotenuse:");
            TextView heightText = (TextView) findViewById(R.id.secondText);
            heightText.setText("Base:");
            chooser =1;
            //The key argument here must match that used in the other activity
        }

        if (key.equals("HY")) {
            TextView hypoText = (TextView) findViewById(R.id.firstText);
            hypoText.setText("Base:");
            TextView heightText = (TextView) findViewById(R.id.secondText);
            heightText.setText("Height:");
            chooser =2;
            //The key argument here must match that used in the other activity
        }

    }

    public void sendMessage(View view) {
        switch (view.getId()) {
            case R.id.GetRTData: {
                EditText txtOne = (EditText) findViewById(R.id.firstData);
                Double dataOne =Double.parseDouble(txtOne.getText().toString());
                EditText txtTwo = (EditText) findViewById(R.id.secondData);
                Double dataTwo =Double.parseDouble(txtTwo.getText().toString());

                if (chooser == 1) {
                    if(dataOne <= dataTwo){
                        TextView textViewResult = (TextView) findViewById(R.id.result);
                        textViewResult.setText("Unavailable Data");

                    }
                    else {
                        Double result = Math.sqrt(Math.pow(dataOne, 2) - Math.pow(dataTwo, 2));
                        TextView textViewResult = (TextView) findViewById(R.id.result);
                        DecimalFormat df = new DecimalFormat("#.####");
                        Double trimDouble = Double.parseDouble(df.format(result));
                        textViewResult.setText(Double.toString(trimDouble));
                    }

                }
                if (chooser == 2) {
                    Double result = Math.sqrt(Math.pow(dataOne,2) + Math.pow(dataTwo,2));
                    TextView textViewResult = (TextView) findViewById(R.id.result);
                    DecimalFormat df = new DecimalFormat("#.####");
                    Double trimDouble = Double.parseDouble(df.format(result));
                    textViewResult.setText(Double.toString(trimDouble));

                }
            }
        }
    }
}
