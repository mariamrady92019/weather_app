package com.example.mymvvmnewstrail.viewsAndViewsModels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mymvvmnewstrail.R;
import com.example.mymvvmnewstrail.viewsAndViewsModels.home.HomePage;

public class MainActivity extends AppCompatActivity {

    public  static  boolean opened = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(opened==true){
            Intent intent = new Intent(MainActivity.this , HomePage.class);
            startActivity(intent);
        }
        new Handler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity.this
                                ,HomePage.class));
                    }
                },2000);
    }

    }

