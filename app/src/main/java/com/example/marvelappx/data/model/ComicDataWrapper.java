package com.example.marvelappx.data.model;


import com.google.gson.annotations.SerializedName;



public class ComicDataWrapper {

    @SerializedName("data")
    private ComicDataContainer data;

    public ComicDataWrapper(ComicDataContainer data) {
        this.data = data;
    }

    public ComicDataContainer getData() {
        return data;
    }
}
