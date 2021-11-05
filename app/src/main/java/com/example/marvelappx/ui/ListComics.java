package com.example.marvelappx.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.marvelappx.R;
import com.example.marvelappx.data.model.Comic;
import com.example.marvelappx.mvp.MvpContrato;
import com.example.marvelappx.mvp.MvpPresenter;

import java.io.Serializable;
import java.util.List;

public class ListComics extends AppCompatActivity implements MvpContrato.ListaComicsView,
        ListComicsAdapter.ItemComicClickListener {

    private ListComicsAdapter listComicsAdapter;
    private MvpContrato.ListaComicsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comics);

        configAdapter();

        presenter = new MvpPresenter(this);
        presenter.obterComic();

        }

        private void configAdapter(){
        Log.i("CONFIG ADAPTER", "config adapter");

        RecyclerView recyclerComics = findViewById(R.id.recycler_comics);

        listComicsAdapter = new ListComicsAdapter(this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(ListComics.this);
        //RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
            recyclerComics.setLayoutManager(linearLayoutManager);
        //recyclerComics.setLayoutManager(gridLayoutManager);
        recyclerComics.setAdapter(listComicsAdapter);
        //recyclerComics.setHasFixedSize(true);

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

    @Override
    public void itemComicClicado(Comic comic) {
        Intent intent = new Intent(getApplicationContext(), DetalhesComics.class);
        intent.putExtra("key",  (Serializable) comic);
        startActivity(intent);

    }

}
