package com.makaroni.albumsaver.utility;

import com.makaroni.albumsaver.jsonObjects.AlbumInfo;
import com.makaroni.albumsaver.jsonObjects.AlbumsQuery;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface LastFmApi {
    @GET("2.0")
    Call<AlbumsQuery> searchAlbums(@QueryMap Map<String,String> call);
    @GET("2.0")
    Call<AlbumInfo> getAlbumInfo(@QueryMap Map<String,String> call);
}
