package com.example.marvelappx.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.marvelappx.R;
import com.example.marvelappx.data.model.Comic;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Handler handler = new Handler();
        handler.postDelayed(this::mostrarFinal, 5000);

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
