package com.example.marvelappx.mvp;

import com.example.marvelappx.data.model.Comic;

import java.util.List;
//interfaces do contrato
public interface MvpContrato {
    interface ListaComicsView{
        void exibirComics(List<Comic> comics);
        void mostrarErro();
    }
    interface ListaComicsPresenter{
        void obterComic();
        void destruirView();
    }
}
