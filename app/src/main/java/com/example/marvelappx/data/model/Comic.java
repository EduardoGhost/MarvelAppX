package com.example.marvelappx.data.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class Comic implements Serializable {

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("thumbnail")
    private Image thumbnail;

    @SerializedName("prices")
    private List<Price> prices;

    private boolean rare;

    public Comic(String title, String description, Image thumbnail, List<Price> prices, boolean rare) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.prices = prices;
        this.rare = rare;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public boolean isRare() {
        return rare;
    }

    public void setRare(boolean rare) {
        this.rare = rare;
    }

}