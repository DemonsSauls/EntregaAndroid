package com.svalero.retrofitthemoviesdb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.svalero.retrofitthemoviesdb.json_mapper.Movie;
import com.svalero.retrofitthemoviesdb.json_mapper.MovieResponse;
import com.svalero.retrofitthemoviesdb.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button boton1;
    private Button boton2;
    private Button boton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = findViewById(R.id.btn01);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hacerFetchPopular();
            }
        });

        boton2 = findViewById(R.id.btn02);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hacerFetchPelis();
            }
        });

        boton3 = findViewById(R.id.btn03);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hacerFetchDetalles();
            }
        });

    }


    private void hacerFetchPopular(){
        Call<MovieResponse> call = RetrofitClient.getInstance().
                getPopularMovies();
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getResults();
                    // Procesa y muestra las películas aquí
                    for (Movie myMovie : movies
                    ) {
                        Toast.makeText(MainActivity.this,
                                "Movie: " + myMovie.getTitle(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }

    private void hacerFetchPelis(){
        Call<MovieResponse> call = RetrofitClient.getInstance().
                getMovie();
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getResults();
                    // Procesa y muestra las películas aquí
                    for (Movie myMovie : movies
                    ) {
                        Toast.makeText(MainActivity.this,
                                "Movie: " + myMovie.getTitle(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }

    private void hacerFetchDetalles(){
        Call<Movie> call = RetrofitClient.getInstance().
                getDetails();
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    Movie movie = response.body();
                    // Procesa y muestra las películas aquí

                        Toast.makeText(MainActivity.this,
                                "Movie: " + movie.getTitle(),
                                Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }
}