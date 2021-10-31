package com.example.marvelappx.data.model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Comic implements Serializable {
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("thumbnail")
    @Expose
    public String thumbnail;
    @SerializedName("prices")
    @Expose
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