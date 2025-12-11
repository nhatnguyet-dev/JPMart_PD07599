package com.example.jpmart_pd07599_v1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jpmart_pd07599_v1.R;

public class WelcomeScreen extends AppCompatActivity {
    private static final int SPLASH_DELAY = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);

        new Handler(Looper.getMainLooper()).postDelayed(()->{
            Intent intent = new Intent(WelcomeScreen.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_DELAY);
    }
}
