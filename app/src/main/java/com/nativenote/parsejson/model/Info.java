
package com.nativenote.parsejson.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Info {

    @SerializedName("directors")
    @Expose
    private List<String> directors = null;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("rating")
    @Expose
    private double rating;
    @SerializedName("genres")
    @Expose
    private List<String> genres = null;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("plot")
    @Expose
    private String plot;
    @SerializedName("rank")
    @Expose
    private long rank;
    @SerializedName("running_time_secs")
    @Expose
    private long runningTimeSecs;
    @SerializedName("actors")
    @Expose
    private List<String> actors = null;

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public long getRunningTimeSecs() {
        return runningTimeSecs;
    }

    public void setRunningTimeSecs(long runningTimeSecs) {
        this.runningTimeSecs = runningTimeSecs;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

}
