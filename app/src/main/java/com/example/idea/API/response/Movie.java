package com.example.idea.API.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("rank")
    @Expose
    private Integer rank;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    @SerializedName("rating")
    @Expose
    private String rating;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("year")
    @Expose
    private Integer year;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("trailer")
    @Expose
    private String trailer;

    @SerializedName("genre")
    @Expose
    private List<String> genre = null;

    @SerializedName("director")
    @Expose
    private List<String> director = null;

    @SerializedName("writers")
    @Expose
    private List<String> writers = null;

    @SerializedName("imdbid")
    @Expose
    private String imdbid;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Movie withRank(Integer rank) {
        this.rank = rank;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Movie withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Movie withThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Movie withRating(String rating) {
        this.rating = rating;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Movie withId(String id) {
        this.id = id;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Movie withYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Movie withImage(String image) {
        this.image = image;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Movie withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Movie withTrailer(String trailer) {
        this.trailer = trailer;
        return this;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public Movie withGenre(List<String> genre) {
        this.genre = genre;
        return this;
    }

    public List<String> getDirector() {
        return director;
    }

    public void setDirector(List<String> director) {
        this.director = director;
    }

    public Movie withDirector(List<String> director) {
        this.director = director;
        return this;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public Movie withWriters(List<String> writers) {
        this.writers = writers;
        return this;
    }

    public String getImdbid() {
        return imdbid;
    }

    public void setImdbid(String imdbid) {
        this.imdbid = imdbid;
    }

    public Movie withImdbid(String imdbid) {
        this.imdbid = imdbid;
        return this;
    }

}