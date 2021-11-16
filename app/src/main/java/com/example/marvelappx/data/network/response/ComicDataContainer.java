package com.example.marvelappx.data.network.response;

import com.example.marvelappx.data.model.Comic;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ComicDataContainer {

    @SerializedName("results")
    private final List<Comic> results;

    public ComicDataContainer(List<Comic> results) {

        this.results = results;
    }

    public List<Comic> getResults() {

        return results;
    }

//talves implementar o random 12% aqui




}
