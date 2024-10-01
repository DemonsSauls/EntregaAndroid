package com.svalero.retrofitthemoviesdb.movies_api;

import com.svalero.retrofitthemoviesdb.json_mapper.Movie;
import com.svalero.retrofitthemoviesdb.json_mapper.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesAPI {
    // Routers!!! express.js
    @GET("movie/popular?api_key=0209ca739b26088eeceffe3ba899f792&language=es-ES&page=1")
    Call<MovieResponse> getPopularMovies();

    @GET("search/movie?api_key=0209ca739b26088eeceffe3ba899f792&language=es-ES&page=1&query=titanic&page=1")
    Call<MovieResponse> getMovie();

    @GET("movie/570?api_key=0209ca739b26088eeceffe3ba899f792&language=es-ES&page=1")
    Call<Movie> getDetails();
}

