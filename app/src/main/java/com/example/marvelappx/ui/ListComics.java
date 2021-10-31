package com.example.marvelappx.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.marvelappx.R;
import com.example.marvelappx.data.model.Comic;
import com.example.marvelappx.data.network.ApiService;
import com.example.marvelappx.data.model.ComicDataWrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListComics extends AppCompatActivity{
    private RecyclerView recyclerComics;
    private ListComicsAdapter listComicsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comics);

        configAdapter();
        obterComic();


        } private void configAdapter(){
        Log.i("CONFIG ADAPTER", "config adapter");
        recyclerComics = findViewById(R.id.recycler_comics);

        listComicsAdapter = new ListComicsAdapter();
        //RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(ListComics.this);
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        recyclerComics.setLayoutManager(gridLayoutManager);
        recyclerComics.setAdapter(this.listComicsAdapter);
        recyclerComics.setHasFixedSize(true);

    }


    public void obterComic(){
        Log.i("CHAMADO ONCREATE", "obter a Lista");


        ApiService.getINSTANCE().getAllComics
                ("1", "87eae2cc29e0e5c27e1978b9b1d484f5","fddd12b1cc463430b1ef5e4853f20b8a")
                .enqueue(new Callback<ComicDataWrapper>() {

                    @Override
                    public void onResponse(Call<ComicDataWrapper> call, Response<ComicDataWrapper> response) {
                        if(response.isSuccessful()){

                            final List<Comic> listaComics = response.body().getData().getResults();
                            listComicsAdapter.setComics(listaComics);
                            Log.i("LISTA RECEBIDA", String.valueOf(listaComics));

                        }else{
                            Log.e("Errou", String.valueOf(""));
                            mostrarErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<ComicDataWrapper> call, Throwable t) {
                        t.printStackTrace();
                        Log.e("entrou no failure", String.valueOf("errou mano"));

                    }
                });
    }


    public void mostrarErro(){
        Toast.makeText(ListComics.this, "Não rodou!", Toast.LENGTH_SHORT).show();
    }

    }
