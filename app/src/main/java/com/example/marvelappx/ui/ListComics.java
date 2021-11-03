package com.example.marvelappx.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.marvelappx.R;
import com.example.marvelappx.data.model.Comic;
import com.example.marvelappx.presenter.ContratoPresenter;
import com.example.marvelappx.presenter.ComicPresenter;

import java.util.ArrayList;
import java.util.List;

public class ListComics extends AppCompatActivity implements ContratoPresenter.ListaComicsView{

    private RecyclerView recyclerComics;
    private ListComicsAdapter listComicsAdapter;
    private ContratoPresenter.ListaComicsPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comics);

        configAdapter();

        presenter = new ComicPresenter(this);
        presenter.obterComic();

        }

        private void configAdapter(){
        Log.i("CONFIG ADAPTER", "config adapter");
        recyclerComics = findViewById(R.id.recycler_comics);

        listComicsAdapter = new ListComicsAdapter();
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(ListComics.this);
        //RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
            recyclerComics.setLayoutManager(linearLayoutManager);
        //recyclerComics.setLayoutManager(gridLayoutManager);
        recyclerComics.setAdapter(listComicsAdapter);

        recyclerComics.setHasFixedSize(true);

    }
    @Override
    public void exibirComics(List<Comic> comics) {
        listComicsAdapter.setComics(comics);
    }


    @Override
    public void mostrarErro(){
        Toast.makeText(ListComics.this, "Não rodou!", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy(){ //necessário caso o vire a tela do smarthphone
        super.onDestroy();
        presenter.destruirView();
    }




    }
