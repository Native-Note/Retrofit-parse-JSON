package com.nativenote.parsejson.request_urls;

import com.nativenote.parsejson.model.MovieInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by IMTIAZ on 3/5/17.
 */

public interface ApiRequestUrls {
    @GET("nalindak/aws-dynamodb-movie-example/master/moviedata.json")
    Call<List<MovieInfo>> getMovies();
}
