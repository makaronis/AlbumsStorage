package com.makaroni.albumsaver.search;

import com.arellomobile.mvp.MvpView;

import com.makaroni.albumsaver.AlbumsQuery;

import java.util.List;

import retrofit2.Response;

public interface SearchView extends MvpView {
    //Map<String,String> sendRequest (String artist, String albumValues);
    void setAlbum(Response<AlbumsQuery> response);
    void setAlbum(String response);
    void showError(String error);
    void initRecyclerView(List<AlbumsQuery.Results.Album.AlbumValues> values);
}
