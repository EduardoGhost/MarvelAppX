package com.example.marvelappx.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.example.marvelappx.R;

public class SplashScreemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screem);

        Handler handler = new Handler();
        handler.postDelayed(this::mostrarListComics, 1);

    }

    private void mostrarListComics() {
        Intent intent = new Intent(getApplicationContext(), ListComics.class);
        startActivity(intent);
        finish();
    }
}