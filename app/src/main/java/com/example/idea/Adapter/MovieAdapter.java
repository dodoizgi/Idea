package com.example.idea.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavAction;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idea.API.response.Movie;
import com.example.idea.Fragment.ListFragmentDirections;
import com.example.idea.R;
import com.example.idea.databinding.MovieItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private final List<Movie> list = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        MovieItemBinding binding = MovieItemBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie =list.get(position);
        if (movie == null)
            return;

        holder.binding.movieNameTextView.setText(movie.getTitle());
        holder.binding.ratingText.setText(movie.getRating());
        holder.binding.yearTextView.setText(String.format("Year : %s", movie.getYear()));

        holder.binding.movieItem.setOnClickListener(view -> {
            NavDirections action = ListFragmentDirections.actionListFragmentToDetailFragment(movie.getId());
            Navigation.findNavController(view).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public MovieItemBinding binding;

        public ViewHolder(MovieItemBinding bindTo) {
            super(bindTo.getRoot());
            binding = bindTo;
        }
    }

    public void changeAll(List<Movie> data) {
        list.clear();
        list.addAll(data);
        notifyDataSetChanged();
    }
}
