package com.example.idea.API;

import com.example.idea.API.response.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceAPI {

    @GET(".")
    @Headers({"X-RapidAPI-Key: 07aa18c400msh1a44d4c736a78afp10f6c3jsneba556f22993",
            "X-RapidAPI-Host: imdb-top-100-movies.p.rapidapi.com"})
    Call<List<Movie>> getAllMovies();

    @GET("/{id}")
    @Headers({"X-RapidAPI-Key: 07aa18c400msh1a44d4c736a78afp10f6c3jsneba556f22993",
            "X-RapidAPI-Host: imdb-top-100-movies.p.rapidapi.com"})
    Call<Movie> getMovieById(@Path("id") String id);

}
