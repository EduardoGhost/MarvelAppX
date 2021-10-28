package com.example.marvelappx.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.marvelappx.R;
import com.example.marvelappx.data.mapper.ComicMapper;
import com.example.marvelappx.data.network.ApiService;
import com.example.marvelappx.data.network.response.ComicResponse;
import com.example.marvelappx.data.network.response.ComicResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListComics extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListComicsAdapter listComicsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configAdapter();

        obterComic();

        } private void configAdapter(){
        recyclerView = findViewById(R.id.recycler_comics);

        listComicsAdapter = new ListComicsAdapter();

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(ListComics.this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listComicsAdapter);

    }

    private void obterComic(){
        ApiService.getINSTANCE().getAllComics
                ("ts=1&apikey=87eae2cc29e0e5c27e1978b9b1d484f5&hash=fddd12b1cc463430b1ef5e4853f20b8a").enqueue
                (new Callback<ComicResult>() {
                    @Override
                    public void onResponse(Call<ComicResult> call, Response<ComicResult> response) {
                        if(response.isSuccessful()){
                            listComicsAdapter.setComics(ComicMapper.
                                    deResponseParaDominio((List<ComicResponse>) response.body().getDados()));

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
