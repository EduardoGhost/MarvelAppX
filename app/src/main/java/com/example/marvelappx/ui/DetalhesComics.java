package com.example.marvelappx.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marvelappx.R;
import com.example.marvelappx.data.model.Comic;
import com.example.marvelappx.data.model.Image;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetalhesComics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_comics);



       // Intent i = getIntent();
        Comic comic = (Comic) getIntent().getSerializableExtra("key");
        TextView txtTitulo = findViewById(R.id.text_comic);

        txtTitulo.setText(comic.getTitle());

        TextView descriçao = findViewById(R.id.text_Descricao2);
        descriçao.setText("Descrição\n" + comic.getDescription());

        TextView preco = findViewById(R.id.text_Precos_2);
        preco.setText("Preço: " + String.valueOf(comic.getPrices().get(0).getPrice()));

        ImageView image = findViewById(R.id.image2);

        Picasso.get().load(comic.getThumbnail().getPath() + "." + //imagem .extensão
                comic.getThumbnail().getExtension())
                .placeholder((R.drawable.ic_launcher_background))
                .error(android.R.drawable.btn_dialog)
                .into(image);



    }
}