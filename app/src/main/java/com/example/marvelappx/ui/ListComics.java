package com.example.marvelappx.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.marvelappx.R;
import com.example.marvelappx.data.model.Comic;

import java.util.Arrays;
import java.util.List;

public class ListComics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recycler_comics);

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new ListComicsAdapter(listaComic()));
    }
        private List<Comic> listaComic(){
           return Arrays.asList(

                    new Comic(1, "hulk", "verde", "jpg", "321"),
            new Comic(2, "spider", "red", "jpg", "100"),
            new Comic(3, "wolve", "amarelo", "jpg", "444"),
                   new Comic(4, "noturno", "azul", "jpg", "454")


            );
        }
    }
