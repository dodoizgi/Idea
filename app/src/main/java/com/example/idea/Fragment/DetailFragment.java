package com.example.idea.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.idea.API.ApiClient;
import com.example.idea.API.ServiceAPI;
import com.example.idea.API.response.Movie;
import com.example.idea.databinding.FragmentDetailBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getMovieById();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getMovieById() {
        ServiceAPI serviceAPI = ApiClient.getRetrofit().create(ServiceAPI.class);
        Call<Movie> call = serviceAPI.getMovieById("top16");
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(@NonNull Call<Movie> call, @NonNull Response<Movie> response) {
                if (response.body() == null)
                    return;

                Movie movie = response.body();
                binding.movieNameText.setText(movie.getTitle());
                binding.directorText.setText(String.format("by %s", convertArrayToString(movie.getDirector())));
                binding.genreText.setText(convertArrayToString(movie.getGenre()));
                binding.descriptionText.setText(movie.getDescription());
                binding.ratingText.setText(movie.getRating());
                binding.writersText.setText(String.format("Directors \n\n%s", convertArrayToString(movie.getWriters())));
            }

            @Override
            public void onFailure(@NonNull Call<Movie> call, @NonNull Throwable t) {
                System.out.println("fail : " + t);
            }
        });
    }

    private String convertArrayToString(List<String> list) {
        StringBuilder listString = new StringBuilder();

        for (String s : list) {
            listString.append(s).append("\n");
        }
        return listString.toString();
    }

}