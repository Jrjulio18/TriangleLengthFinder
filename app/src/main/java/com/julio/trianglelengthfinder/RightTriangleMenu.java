package com.julio.trianglelengthfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by ACER on 7/12/2016.
 */
public class RightTriangleMenu extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.right__triangle_menu);
    }
    public void sendMessage(View view){
        switch (view.getId()){

            case R.id.baseFinderButton:{
                Intent intent = new Intent(this,RightTriangleData.class);
                intent.putExtra("key","BF");
                startActivity(intent);
                break;
            }
            case R.id.HeightFinderButton:{
                Intent intent = new Intent(this,RightTriangleData.class);
                intent.putExtra("key","HF");
                startActivity(intent);
                break;
            }
            case R.id.HypoFinderButton:{
                Intent intent = new Intent(this,RightTriangleData.class);
                intent.putExtra("key","HY");
                startActivity(intent);
                break;
            }
            case R.id.AngleFinderButton:{
                Intent intent = new Intent(this,RightTriangleData.class);
                intent.putExtra("key","AF");
                startActivity(intent);
                break;
            }
        }
    }
}
