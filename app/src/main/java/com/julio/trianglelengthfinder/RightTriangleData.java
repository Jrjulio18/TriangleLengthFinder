package com.julio.trianglelengthfinder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ACER on 7/15/2016.
 */
public class RightTriangleData extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.right_triangle_data);

        Bundle extras = getIntent().getExtras();
       // View myview = new View(this);
        String key = extras.getString("key");
        if (key.equals("BF")) {
            TextView hypoText = (TextView) findViewById(R.id.firstText);
            hypoText.setText("Hypotenuse:");
            TextView heightText = (TextView) findViewById(R.id.secondText);
            heightText.setText("Height:");
           // sendMessage(myview,1);
            //The key argument here must match that used in the other activity
        }
//Second Option
        if (key.equals("HF")) {
            TextView hypoText = (TextView) findViewById(R.id.firstText);
            hypoText.setText("Hypotenuse:");
            TextView heightText = (TextView) findViewById(R.id.secondText);
            heightText.setText("Base:");
          // sendMessage(myview,1);
            //The key argument here must match that used in the other activity
        }

        if (key.equals("HY")) {
            TextView hypoText = (TextView) findViewById(R.id.firstText);
            hypoText.setText("Base:");
            TextView heightText = (TextView) findViewById(R.id.secondText);
            heightText.setText("Height:");
            //The key argument here must match that used in the other activity
        }

        if (key.equals("AF")) {
            TextView hypoText = (TextView) findViewById(R.id.firstText);
            hypoText.setText("Hypotenuse:");
            TextView heightText = (TextView) findViewById(R.id.secondText);
            heightText.setText("Height:");
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

              //  if (number == 1) {
                    Double result = Math.sqrt(Math.pow(dataOne,2) - Math.pow(dataTwo,2));
                    TextView textViewResult = (TextView) findViewById(R.id.result);
                    textViewResult.setText(Double.toString(result));
               // }
            }
        }
    }
}
