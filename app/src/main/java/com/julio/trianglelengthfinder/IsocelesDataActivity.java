package com.julio.trianglelengthfinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class IsocelesDataActivity extends AppCompatActivity {
    static int chooser = 0;
    static int checker= 0;
    CheckBox checkBoxHeight, checkBoxBase, checkBoxAngle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isoceles_data);

        checkBoxHeight = (CheckBox) findViewById(R.id.checkBoxHeight);
        checkBoxBase = (CheckBox) findViewById(R.id.checkBoxBase);
        checkBoxAngle = (CheckBox) findViewById(R.id.checkBoxAngle);

        Bundle extras = getIntent().getExtras();

        String key = extras.getString("key");
        if (key.equals("BFI")) {
           checkBoxHeight.setText("Leg:");
           checkBoxBase.setText("Height:");
            checkBoxAngle.setText("Angle of Leg:");
            chooser = 1;
            //The key argument here must match that used in the other activity
        }

        if (key.equals("HFI")) {
            checkBoxHeight.setVisibility(View.GONE);
            checkBoxBase.setVisibility(View.GONE);
            EditText editText = (EditText) findViewById(R.id.isoThirdData);
            editText.setVisibility(View.GONE);
            checkBoxAngle.setVisibility(View.GONE);

            EditText txtOne = (EditText) findViewById(R.id.isoFirstData);
            txtOne.setVisibility(View.VISIBLE);
            EditText txtTwo = (EditText) findViewById(R.id.isoSecondData);
            txtTwo.setVisibility(View.VISIBLE);

            TextView legText = (TextView) findViewById(R.id.textViewLeg);
            legText.setText("Leg:");
            legText.setVisibility(View.VISIBLE);
            TextView baseText = (TextView) findViewById(R.id.textViewBase);
            baseText.setText("Base:");
           baseText.setVisibility(View.VISIBLE);
            chooser = 2;

            //The key argument here must match that used in the other activity
        }

        if (key.equals("EFI")) {

            checkBoxHeight.setText("Height:");
            checkBoxBase.setText("Base:");
            checkBoxAngle.setText("Angle of Leg:");
            chooser = 3;
            //The key argument here must match that used in the other activity
        }
    }
    public void checkOne(View view){
        if(!checkBoxHeight.isChecked()){
            EditText txtOne = (EditText) findViewById(R.id.isoFirstData);
            txtOne.setVisibility(View.GONE);
        }
        if (!checkBoxBase.isChecked()){
            EditText txtTwo = (EditText) findViewById(R.id.isoSecondData);
            txtTwo.setVisibility(View.GONE);
        }
        if (!checkBoxAngle.isChecked()){
            EditText txtThree = (EditText) findViewById(R.id.isoThirdData);
            txtThree.setVisibility(View.GONE);
        }
        if(checkBoxHeight.isChecked()){
            EditText txtOne = (EditText) findViewById(R.id.isoFirstData);
            txtOne.setVisibility(View.VISIBLE);
        }
        if (checkBoxBase.isChecked()){
            EditText txtTwo = (EditText) findViewById(R.id.isoSecondData);
            txtTwo.setVisibility(View.VISIBLE);
        }
        if (checkBoxAngle.isChecked()){
            EditText txtThree = (EditText) findViewById(R.id.isoThirdData);
            txtThree.setVisibility(View.VISIBLE);
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
                    TextView heightDisplay = (TextView)findViewById(R.id.lengthDisplay);
                    heightDisplay.setText("Height Size");
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
