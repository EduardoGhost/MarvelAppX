package com.example.marvelappx.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.versionedparcelable.ParcelField;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public Comic(String title, String description, Image thumbnail, List<Price> prices) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.prices = prices;
        this.rare = false;
    }


}