package com.nativenote.movielist_retrofit;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.nativenote.movielist_retrofit.adapter.MovieAdapter;
import com.nativenote.movielist_retrofit.client.ApiClient;
import com.nativenote.movielist_retrofit.model.MovieInfo;
import com.nativenote.movielist_retrofit.request_urls.ApiRequestUrls;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<MovieInfo> movies = new ArrayList<>();
    private RecyclerView recyclerView;
    private MovieAdapter mAdapter;
    private TextView emptyView;
    private ProgressDialog pDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        emptyView = (TextView) findViewById(R.id.empty_view);
        mAdapter = new MovieAdapter(MainActivity.this, movies);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pDialog != null && pDialog.isShowing()){
                    pDialog.dismiss();
                }

                pDialog = new ProgressDialog(MainActivity.this);
                pDialog.setMessage("Loading");
                pDialog.setCancelable(false);
                pDialog.show();

                SyncData();
            }
        });
    }

    private void SyncData() {
        ApiRequestUrls apis = ApiClient.getApiInterface(Utils.END_POINT);
        Call<List<MovieInfo>> call = apis.getMovies();
        call.enqueue(new Callback<List<MovieInfo>>() {
            @Override
            public void onResponse(Call<List<MovieInfo>> call, Response<List<MovieInfo>> response) {
                movies.clear();
                movies = response.body();

                if (movies.isEmpty()) {
                    recyclerView.setVisibility(View.GONE);
                    emptyView.setVisibility(View.VISIBLE);
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    emptyView.setVisibility(View.GONE);
                    mAdapter.setMovies(movies);
                    mAdapter.notifyDataSetChanged();
                }

                if(pDialog != null && pDialog.isShowing()){
                    pDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<MovieInfo>> call, Throwable t) {
                recyclerView.setVisibility(View.GONE);
                emptyView.setVisibility(View.VISIBLE);

                if(pDialog != null && pDialog.isShowing()){
                    pDialog.dismiss();
                }
            }
        });
    }
}
