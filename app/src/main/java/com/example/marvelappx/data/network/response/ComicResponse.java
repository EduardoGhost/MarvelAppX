package com.example.marvelappx.data.network.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComicResponse {
    @SerializedName("results")
    @Expose
private String resultado;


    public ComicResponse(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }
}
