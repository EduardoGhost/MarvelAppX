package com.example.marvelappx.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

//miniatura das imagens
public class Image implements Serializable {

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


}


