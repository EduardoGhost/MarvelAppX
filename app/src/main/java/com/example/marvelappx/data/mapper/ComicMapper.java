package com.example.marvelappx.data.mapper;

import com.example.marvelappx.data.model.Comic;
import com.example.marvelappx.data.network.response.ComicResponse;
import com.example.marvelappx.data.network.response.ComicResult;

import java.util.ArrayList;
import java.util.List;

public class ComicMapper {

    public static List<Comic> deResponseParaDominio(List<ComicResponse> listaComicResponse){
        List<Comic> listaComics = new ArrayList<>();

        for(ComicResponse comicResponse : listaComicResponse){
            final Comic comic = new Comic(comicResponse.getData());
            listaComics.add(comic);
        }
        return listaComics;
    }
}