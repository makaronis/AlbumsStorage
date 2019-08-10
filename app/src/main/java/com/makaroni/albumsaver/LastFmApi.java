package com.makaroni.albumsaver;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface LastFmApi {
    @GET("2.0")
    Call<AlbumsQuery> getAlbum(@QueryMap Map<String,String> call);

}
