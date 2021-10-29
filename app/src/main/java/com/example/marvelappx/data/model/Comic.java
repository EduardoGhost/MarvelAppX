package com.example.marvelappx.data.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Comic implements Serializable {
    @SerializedName("title")
    public String title;
    @SerializedName("description")
    public String description;
    @SerializedName("thumbnail")
    public String thumbnail;
    @SerializedName("prices")
    private List<Price> prices;


    public Comic(String title, String description, String thumbnail, List<Price> prices) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.prices = prices;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public List<Price> getPrices() {
        return prices;
    }





}