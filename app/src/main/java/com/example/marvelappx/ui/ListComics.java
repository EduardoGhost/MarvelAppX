package com.example.marvelappx.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.marvelappx.R;
import com.example.marvelappx.data.mapper.ComicMapper;
import com.example.marvelappx.data.model.Comic;
import com.example.marvelappx.data.network.ApiService;
import com.example.marvelappx.data.network.response.ComicResponse;
import com.example.marvelappx.data.network.response.ComicResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListComics extends AppCompatActivity {
    private RecyclerView recyclerComics;
    private ListComicsAdapter listComicsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comics);

        configAdapter();

        obterComic();

        } private void configAdapter(){
        recyclerComics = findViewById(R.id.recycler_comics);

        listComicsAdapter = new ListComicsAdapter();

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        recyclerComics.setLayoutManager(gridLayoutManager);
        recyclerComics.setAdapter(listComicsAdapter);

    }

    private void obterComic(){
        ApiService.getINSTANCE().getAllComics
                ("1", "87eae2cc29e0e5c27e1978b9b1d484f5","fddd12b1cc463430b1ef5e4853f20b8a").enqueue
                (new Callback<ComicResult>() {
                    @Override
                    public void onResponse(Call<ComicResult> call, Response<ComicResult> response) {
                        if(response.isSuccessful()){
                            final List<Comic> listaComics = ComicMapper.
                                    deResponseParaDominio(response.body().getResults());
                            listComicsAdapter.setComics(listaComics);

                        }else{
                            mostrarErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<ComicResult> call, Throwable t) {

                    }
                });
    }


    public void mostrarErro(){
        Toast.makeText(ListComics.this, "Não rodou!", Toast.LENGTH_SHORT).show();
    }

    }
