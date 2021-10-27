package com.example.marvelappx.data.model;

public class ResponseData {
    private ComicData data;

    public ResponseData(ComicData data) {
        this.data = data;
    }

    public ComicData getData() {
        return data;
    }

    public void setData(ComicData data) {
        this.data = data;
    }
}
