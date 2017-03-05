package com.nativenote.parsejson.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nativenote.parsejson.R;
import com.nativenote.parsejson.model.MovieInfo;

import java.util.List;

/**
 * Created by imtiaz on 3/2/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context context;
    private List<MovieInfo> movies;

    public MovieAdapter(Context context, List<MovieInfo> movies) {
        this.context = context;
        this.movies = movies;
    }

    public void setMovies(List<MovieInfo> movies) {
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_row, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MovieInfo contact = movies.get(position);
        holder.title.setText(contact.getTitle());
        holder.year.setText(String.valueOf(contact.getInfo().getRating()));
        holder.release.setText("Release year: " + contact.getYear());
        holder.actors.setText(TextUtils.join(", ", contact.getInfo().getActors()));
        holder.plot.setText(contact.getInfo().getPlot());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title, year, release, plot, actors;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            year = (TextView) view.findViewById(R.id.rating);
            release = (TextView) view.findViewById(R.id.release);
            plot = (TextView) view.findViewById(R.id.plot);
            actors = (TextView) view.findViewById(R.id.actors);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "Clicked: " + movies.get(getAdapterPosition()).getTitle(), Toast.LENGTH_LONG).show();
        }
    }
}
