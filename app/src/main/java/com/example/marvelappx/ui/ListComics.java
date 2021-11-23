package com.example.marvelappx.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.marvelappx.R;
import com.example.marvelappx.data.model.Comic;
import com.example.marvelappx.mvp.Contrato;
import com.example.marvelappx.mvp.Presenter;

import java.util.List;

public class ListComics extends AppCompatActivity implements Contrato.ListaComicsView,
        ListComicsAdapter.ItemComicClickListener {

    private ListComicsAdapter listComicsAdapter;
    private Contrato.ListaComicsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comics);

        configAdapter();

        presenter = new Presenter(this);
        presenter.obterComic();

        }

        private void configAdapter(){

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
    protected void onDestroy(){
        super.onDestroy();
        presenter.destruirView();
    }

    @Override
    public void itemComicClicado(Comic comic) {
        Intent intent = new Intent(getApplicationContext(), DetalhesComics.class);
        intent.putExtra("key", comic);
        startActivity(intent);

    }

}
