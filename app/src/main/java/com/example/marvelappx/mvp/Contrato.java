package com.example.marvelappx.mvp;

import com.example.marvelappx.data.model.Comic;

import java.util.List;

public interface Contrato {
    interface ListaComicsView{
        void exibirComics(List<Comic> comics);
        void mostrarErro();
    }
    interface ListaComicsPresenter{
        void obterComic();
        void destruirView();
    }
}
