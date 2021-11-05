package com.example.marvelappx.data.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

//preços
public class Price implements Serializable, Parcelable {
    private String type;
    private double price;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static Creator<Price> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeDouble(this.price);
    }

    protected Price(Parcel in) {
        this.type = in.readString();
        this.price = in.readDouble();
    }

    public static final Parcelable.Creator<Price> CREATOR = new Parcelable.Creator<Price>() {
        @Override
        public Price createFromParcel(Parcel source) {
            return new Price(source);
        }

        @Override
        public Price[] newArray(int size) {
            return new Price[size];
        }
    };
}
