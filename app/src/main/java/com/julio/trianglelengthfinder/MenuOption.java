package com.julio.trianglelengthfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MenuOption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_option);


    }public void sendMessage(View view){
        switch (view.getId()){

            case R.id.RightTriangleOption:{
                Intent intent = new Intent(this,RightTriangleMenu.class);
                startActivity(intent);
                break;
            }
            case R.id.equilateralTriangleOption:{
                Intent intent = new Intent(this,IsocelesTriangleMenu.class);
                startActivity(intent);
                break;
            }
            case R.id.IsocelesTriangleOption:{
                Intent intent = new Intent(this,IsoMenu.class);
                startActivity(intent);
                break;
            }
        }
    }


}
