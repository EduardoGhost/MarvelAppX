package com.example.marvelappx.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComicResult {

    @SerializedName("data")
    @Expose
    private final List<ComicResponse> dados;


    public ComicResult(List<ComicResponse> dados) {
        this.dados = dados;
    }

    public List<ComicResponse> getDados() {
        return dados;
    }
}
