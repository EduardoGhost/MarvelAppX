package com.example.marvelappx.data.network.response;

import com.example.marvelappx.data.model.Comic;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComicResult {

    @SerializedName("results")
    private List<Comic> results;

    public ComicResult(List<Comic> results) {
        this.results = results;
    }

    public List<Comic> getResults() {
        return results;
    }
}
