package com.example.marvelappx.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.marvelappx.R;
import com.example.marvelappx.data.model.Comic;
import com.google.android.material.slider.Slider;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        findViewById(R.id.final_imagem).animate().translationXBy(-2000).setDuration(6000).setStartDelay(1000);
        findViewById(R.id.cwarr).animate().translationXBy(-2000).setDuration(6000).setStartDelay(6000);
        findViewById(R.id.cwar).animate().translationXBy(-2000).setDuration(6000).setStartDelay(11000);


        Handler handler = new Handler();
        handler.postDelayed(this::mostrarFinal, 20000);

        String total = getIntent().getStringExtra("keyFinal1");
        Comic comic = (Comic) getIntent().getSerializableExtra("keyFinal2");

        TextView txtTotal = findViewById(R.id.text_total_final);

        txtTotal.setText("Novo total: R$: "+ String.format("%.4s", total));
    }

    private void mostrarFinal() {
        Intent intent = new Intent(getApplicationContext(), ListComics.class);
        startActivity(intent);
        finish();
    }
}
