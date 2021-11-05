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

public class Comic implements Parcelable, Serializable {

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("thumbnail")
    private Image thumbnail;

    @SerializedName("prices")
    private List<Price> prices;


    public String getTitle() {
        return this.title = Objects.requireNonNull(title);
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

    public Comic(String title, String description, Image thumbnail, List<Price> prices) {
        this.title = Objects.requireNonNull(title);
        this.description = description;
        this.thumbnail = thumbnail;
        this.prices = prices;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeParcelable(this.thumbnail, flags);
        dest.writeTypedList(this.prices);

    }

    public void readFromParcel(Parcel source) {
        this.title = source.readString();
        this.description = source.readString();
        this.prices = source.createTypedArrayList(Price.CREATOR);
        this.thumbnail = source.readParcelable(Image.class.getClassLoader());

    }


    protected Comic(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.thumbnail = in.readParcelable(Image.class.getClassLoader());
        this.prices = in.createTypedArrayList(Price.CREATOR);
        in.readList(this.prices, Price.class.getClassLoader());

    }

    public static final Creator <Comic> CREATOR = new Creator<Comic>() {
        @Override
        public Comic createFromParcel(Parcel source) {
            return new Comic(source);
        }

        @Override
        public Comic[] newArray(int size) {
            return new Comic[size];
        }
    };
}