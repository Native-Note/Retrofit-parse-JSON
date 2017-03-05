
package com.nativenote.parsejson.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieInfo {

    @SerializedName("year")
    @Expose
    private long year;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("info")
    @Expose
    private Info info;

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}
