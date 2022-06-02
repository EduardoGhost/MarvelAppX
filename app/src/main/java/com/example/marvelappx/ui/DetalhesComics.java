package com.example.marvelappx.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.marvelappx.R;
import com.example.marvelappx.data.model.Comic;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Random;


public class DetalhesComics extends AppCompatActivity {

    //private NumberPicker numberPicker;
    private Button buttonC;
    private Button buttonVideo;

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

        TextView total = findViewById(R.id.text_total);
        buttonC = (Button) findViewById(R.id.buttonC);

        buttonVideo = (Button) findViewById(R.id.buttonVideo);

        //quantidade
        EditText editText = findViewById(R.id.edit);
        editText.setText("");


        //url de videos
     //   String [] arrayURL = {"https://www.youtube.com/watch?v=Jrpv1C0WHFI", "https://www.youtube.com/watch?v=2Lba2qhWBe8"};

        buttonVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VideoViewActivity.class);
                startActivity(intent);
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //preco.setText("Preço: " + String.valueOf(comic.getPrices().get(0).getPrice()));

                Intent intent = new Intent(DetalhesComics.this, CheckoutActivity.class);
                intent.putExtra("keyy",  editText.getText().toString());
                intent.putExtra("keyx", (Serializable) comic);
                startActivity(intent);
            }
        });

    }
}