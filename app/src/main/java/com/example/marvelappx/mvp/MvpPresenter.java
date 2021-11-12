package com.example.marvelappx.mvp;

import android.util.Log;

import com.example.marvelappx.data.model.Comic;
import com.example.marvelappx.data.network.response.ComicDataWrapper;
import com.example.marvelappx.data.network.ApiService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MvpPresenter implements MvpContrato.ListaComicsPresenter{

    private MvpContrato.ListaComicsView view;
    public MvpPresenter(MvpContrato.ListaComicsView view){
        this.view = view;
    }

    @Override
    public void obterComic(){
        Log.i("CHAMADO ONCREATE", "obter a Lista");
        //comunicação com a api
        ApiService.getINSTANCE().getAllComics
                ("1", "87eae2cc29e0e5c27e1978b9b1d484f5","fddd12b1cc463430b1ef5e4853f20b8a", "20")
                .enqueue(new Callback<ComicDataWrapper>() {
                    @Override
                    public void onResponse(Call<ComicDataWrapper> call, Response<ComicDataWrapper> response) {
                        if(response.isSuccessful()){
                            List<Comic> listaComics = filtro(response.body().getData().getResults());

                            List<Comic> newList = randomRare(listaComics);
                            //List<Comic> newList = comicRare(listaComics);
                            Collections.shuffle(newList);


                            //view.exibirComics(listaComics);
                            view.exibirComics(newList);
                        }else{
                            Log.e("Errou", String.valueOf(""));
                        }
                    }

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

    public static final String IMG_NOT_AVAILABLE = "image_not_available";
    private List<Comic> filtro(List<Comic> comics){
        List<Comic> filtroComics = new ArrayList<>();
        for(Comic comic : comics){
            if(!comic.getThumbnail().getUrl().contains(IMG_NOT_AVAILABLE)){
                filtroComics.add(comic);

            }
        }return filtroComics;
    }

    public List<Comic> comicRare(List<Comic> comicRare){

        Collections.shuffle(comicRare);

        int cont = 0;
        int x = comicRare.size();
        while (cont != x){


            if(comicRare.get(cont).isRare() == false) {
                comicRare.get(cont).setRare(true);
                System.out.println("RARO: "+ comicRare.get(cont));
                break;

        }cont++;
            System.out.println("CONT: "+cont);
        }
        return comicRare;

    }

    public List<Comic> randomRare(List<Comic> comicRandom) {
        Random random = new Random();

        for (int i = 0; i < (comicRandom.size()-1); i++) {
                int j = random.nextInt(comicRandom.size());
                comicRandom.get(j).setRare(true);
                break;

        }return comicRandom;


}
}

