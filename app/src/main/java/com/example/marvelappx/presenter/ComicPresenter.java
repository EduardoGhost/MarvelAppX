package com.example.marvelappx.presenter;

import android.util.Log;

import com.example.marvelappx.data.model.Comic;
import com.example.marvelappx.data.network.response.ComicDataWrapper;
import com.example.marvelappx.data.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComicPresenter implements ContratoPresenter.ListaComicsPresenter{

    private ContratoPresenter.ListaComicsView view;
    public ComicPresenter(ContratoPresenter.ListaComicsView view){
        this.view = view;
    }

    @Override
    public void obterComic(){
        Log.i("CHAMADO ONCREATE", "obter a Lista");
        //comunicação com a api
        ApiService.getINSTANCE().getAllComics
                ("1", "87eae2cc29e0e5c27e1978b9b1d484f5","fddd12b1cc463430b1ef5e4853f20b8a")
                .enqueue(new Callback<ComicDataWrapper>() {
                    @Override
                    public void onResponse(Call<ComicDataWrapper> call, Response<ComicDataWrapper> response) {
                        if(response.isSuccessful()){
                            final List<Comic> listaComics = response.body().getData().getResults();
                            //listComicsAdapter.setComics(listaComics);
                            Log.i("LISTA RECEBIDA", String.valueOf(listaComics));
                            view.exibirComics(listaComics);
                        }else{
                            Log.e("Errou", String.valueOf(""));
                        }}

                    @Override
                    public void onFailure(Call<ComicDataWrapper> call, Throwable t) {
                        t.printStackTrace();
                        Log.e("entrou no failure", String.valueOf("errou feio"));
                        view.mostrarErro();
                    }
                });
    }

    @Override
    public void destruirView() {
        this.view = null;
    }
}

