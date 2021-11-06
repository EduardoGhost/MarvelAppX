package com.example.marvelappx.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marvelappx.R;
import com.example.marvelappx.data.model.Comic;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_activity);

    Comic comic = (Comic) getIntent().getSerializableExtra("keyy");
    TextView txtTitulo = findViewById(R.id.text_comicC);

        txtTitulo.setText("coça os bolsos");


}}
