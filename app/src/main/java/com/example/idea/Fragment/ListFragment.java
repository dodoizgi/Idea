package com.example.idea.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.idea.API.ApiClient;
import com.example.idea.API.ServiceAPI;
import com.example.idea.API.response.Movie;
import com.example.idea.Adapter.MovieAdapter;
import com.example.idea.databinding.FragmentListBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFragment extends Fragment {

    private FragmentListBinding binding;
    MovieAdapter movieAdapter = new MovieAdapter();
    private List<Movie> movieList = new ArrayList<>();

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.movieList.setAdapter(movieAdapter);
        binding.movieList.setLayoutManager(new LinearLayoutManager(getContext()));
        getMovies();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getMovies() {
        ServiceAPI serviceAPI = ApiClient.getRetrofit().create(ServiceAPI.class);
        Call<List<Movie>> call = serviceAPI.getAllMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(@NonNull Call<List<Movie>> call, @NonNull Response<List<Movie>> response) {
                if (!response.isSuccessful())
                    return;

                movieList.clear();
                movieList = response.body();
                movieAdapter.changeAll(movieList);

            }

            @Override
            public void onFailure(@NonNull Call<List<Movie>> call, @NonNull Throwable t) {
                System.out.printf("fail : %s%n", t);
            }
        });
    }
}