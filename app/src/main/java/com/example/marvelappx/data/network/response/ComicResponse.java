package com.example.marvelappx.data.network.response;


import com.example.marvelappx.data.model.Comic;
import com.example.marvelappx.ui.ListComics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComicResponse {

    @SerializedName("data")
    private ComicResponse data;

    public ComicResponse(ComicResponse data) {
        this.data = data;
    }

    public ComicResponse getData() {
        return data;
    }
}
