package com.julio.trianglelengthfinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class IsocelesDataActivity extends AppCompatActivity {
    static int chooser = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isoceles_data);
        Bundle extras = getIntent().getExtras();

        String key = extras.getString("key");
        if (key.equals("BFI")) {
            TextView legText = (TextView) findViewById(R.id.isoFirstText);
            legText.setText("Leg:");
            TextView heightText = (TextView) findViewById(R.id.isoSecondText);
            heightText.setText("Height:");
            TextView angleText = (TextView) findViewById(R.id.isoThirdText);
            angleText.setText("Angle of Leg:");
            chooser = 1;
            //The key argument here must match that used in the other activity
        }

        if (key.equals("HFI")) {
            TextView legText = (TextView) findViewById(R.id.isoFirstText);
            legText.setText("Leg:");
            TextView baseText = (TextView) findViewById(R.id.isoSecondText);
            baseText.setText("Base:");
            EditText editText =(EditText) findViewById(R.id.isoThirdData);
            editText.setVisibility(View.GONE);
            chooser = 2;

            //The key argument here must match that used in the other activity
        }

        if (key.equals("EFI")) {
            TextView heightText = (TextView) findViewById(R.id.isoFirstText);
            heightText.setText("Height:");
            TextView baseText = (TextView) findViewById(R.id.isoSecondText);
            baseText.setText("Base:");
            TextView angleText = (TextView) findViewById(R.id.isoThirdText);
            angleText.setText("Angle of Leg:");
            chooser = 3;
            //The key argument here must match that used in the other activity
        }
    }

    public void sendMessage(View view) {
        switch (view.getId()) {
            case R.id.isoButtonLength:{
                EditText txtOne = (EditText) findViewById(R.id.isoFirstData);
                Double dataOne =Double.parseDouble(txtOne.getText().toString());
                EditText txtTwo = (EditText) findViewById(R.id.isoSecondData);
                Double dataTwo =Double.parseDouble(txtTwo.getText().toString());

                if(chooser == 1){
                    EditText txtThree = (EditText) findViewById(R.id.isoThirdData);
                    Double dataThree =Double.parseDouble(txtThree.getText().toString());
                    if(dataTwo != 0 && (dataThree == 0 || dataThree == null)) {
                        Double base = 2 * (Math.sqrt(Math.pow(dataOne, 2) - Math.pow(dataTwo, 2)));
                        TextView textViewResult = (TextView) findViewById(R.id.isoResultData);
                        DecimalFormat df = new DecimalFormat("#.####");
                        Double trimDouble = Double.parseDouble(df.format(base));
                        textViewResult.setText(Double.toString(trimDouble));
                    }
                    if(dataThree != 0 && (dataTwo == 0 || dataTwo == null)) {
                        Double base = 2 *dataOne *  Math.cos(Math.toRadians(dataThree));
                        TextView textViewResult = (TextView) findViewById(R.id.isoResultData);
                        DecimalFormat df = new DecimalFormat("#.####");
                        Double trimDouble = Double.parseDouble(df.format(base));
                        textViewResult.setText(Double.toString(trimDouble));
                    }
                }

                if(chooser == 2 ){
                    Double height = Math.sqrt(Math.pow(dataOne, 2) - Math.pow((dataTwo/2), 2));
                    TextView textViewResult = (TextView) findViewById(R.id.isoResultData);
                    DecimalFormat df = new DecimalFormat("#.####");
                    Double trimDouble = Double.parseDouble(df.format(height));
                    textViewResult.setText(Double.toString(trimDouble));
                }

                if(chooser == 3) {
                    EditText txtThree = (EditText) findViewById(R.id.isoThirdData);
                    Double dataThree =Double.parseDouble(txtThree.getText().toString());
                    if(dataTwo != 0 && (dataThree == 0 || dataThree == null)) {
                        Double leg = (Math.sqrt(Math.pow(dataOne, 2) + Math.pow(dataTwo, 2)));
                        TextView textViewResult = (TextView) findViewById(R.id.isoResultData);
                        DecimalFormat df = new DecimalFormat("#.####");
                        Double trimDouble = Double.parseDouble(df.format(leg));
                        textViewResult.setText(Double.toString(trimDouble));
                    }
                    if(dataThree != 0 && (dataTwo == 0 || dataTwo == null)) {
                        Double leg = dataOne / (Math.sin(Math.toRadians(dataThree)));
                        TextView textViewResult = (TextView) findViewById(R.id.isoResultData);
                        DecimalFormat df = new DecimalFormat("#.####");
                        Double trimDouble = Double.parseDouble(df.format(leg));
                        textViewResult.setText(Double.toString(trimDouble));

                    }
                }
            }
        }
    }
}
