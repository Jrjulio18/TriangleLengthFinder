package com.julio.trianglelengthfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IsoMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view){
        switch (view.getId()){

            case R.id.baseFinderButtonIso:{
                Intent intent = new Intent(this,IsocelesDataActivity.class);
                intent.putExtra("key","BFI");
                startActivity(intent);
                break;
            }
            case R.id.HeightFinderButtonIso:{
                Intent intent = new Intent(this,IsocelesDataActivity.class);
                intent.putExtra("key","HFI");
                startActivity(intent);
                break;
            }

            case R.id.EqualButtonIso:{
                Intent intent = new Intent(this,IsocelesDataActivity.class);
                intent.putExtra("key","EFI");
                startActivity(intent);
                break;
            }
        }
    }
}
