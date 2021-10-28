package com.example.marvelappx.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComicResult {

    @SerializedName("data")
    private ComicResponse dados;



    public ComicResult(ComicResponse dados) {
        this.dados = dados;
    }



    public ComicResponse getDados() {
        return dados;
    }
}
