package com.example.marvelappx.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

//miniatura das imagens
public class Image implements Serializable, Parcelable {

    final String RESOLUTION = "/portrait_fantastic";

    @SerializedName("path")
    private String path;

    @SerializedName("extension")
    private String extension;

    public Image(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public String getPath() {
        return path;

    }

    public String getExtension() {
        return extension;
    }

    public String getUrl() {
        return getPath()+RESOLUTION+"."+getExtension();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.path);
        dest.writeString(this.extension);
    }
    protected Image(Parcel in) {
        this.path = in.readString();
        this.extension = in.readString();
    }
    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
};
}


