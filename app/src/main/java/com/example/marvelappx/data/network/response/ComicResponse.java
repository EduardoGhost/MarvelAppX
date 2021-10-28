package com.example.marvelappx.data.network.response;


import com.example.marvelappx.data.model.Comic;
import com.example.marvelappx.ui.ListComics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComicResponse {

    @SerializedName("results")
    private List<Comic> resultados;

    public ComicResponse(List<Comic> resultados) {
        this.resultados = resultados;
    }

    public List<Comic> getResultado() {
        return resultados;
    }
}
