package com.example.marvelappx.data.network.response;


import com.example.marvelappx.data.model.Comic;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComicDataContainer {

    @SerializedName("results")
    private final List<Comic> results;

    public ComicDataContainer(List<Comic> results) {
        this.results = results;
    }

    public List<Comic> getResults() {
        return results;
    }
}
