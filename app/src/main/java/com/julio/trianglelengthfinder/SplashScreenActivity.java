package com.julio.trianglelengthfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class SplashScreenActivity extends AppCompatActivity {

    public LinearLayout linearLayout;
    public static int splashImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        linearLayout = (LinearLayout) findViewById(R.id.layout_splashscreen);

        if( splashImage == 0){
            linearLayout.setBackgroundResource(R.drawable.sp);
        }
        else{
            linearLayout.setBackgroundResource(splashImage);
        }

        Thread displaySplash = new Thread(){

            public void run(){
                try{
                    sleep(3*1000);
                    Intent intent = new Intent(getBaseContext(),MenuOption.class);
                    startActivity(intent);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    finish();
                }
            }
        };
        displaySplash.start();
    }
}
