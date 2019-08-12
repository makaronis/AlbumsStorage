package com.makaroni.albumsaver.search;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import com.makaroni.albumsaver.jsonObjects.AlbumsQuery;
import com.makaroni.albumsaver.utility.LastFmApi;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@InjectViewState
public class SearchPresenter extends MvpPresenter<SearchView> {
    Map<String,String> map;
    Retrofit retrofit;
    LastFmApi lastFmApi;

    public SearchPresenter() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://ws.audioscrobbler.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        lastFmApi = retrofit.create(LastFmApi.class);
    }
    public void showAlbums(Map<String,String> map){
        Call<AlbumsQuery> call = lastFmApi.searchAlbums(map);
        try {
            call.enqueue(new Callback<AlbumsQuery>(){
                @Override
                public void onResponse(Call<AlbumsQuery> call, Response<AlbumsQuery> response) {
                    if (!response.isSuccessful()) {
                        getViewState().showError("No such albumValues");
                        return;
                    }
                    if (response.body()==null){
                        getViewState().showError("No such albumValues");
                        return;
                    }
                    List<AlbumsQuery.Results.Album.AlbumValues> albumValues = response.body().getResults().getAlbummatches().getAlbumValues();
                    getViewState().initRecyclerView(albumValues);

                }

                @Override
                public void onFailure(Call<AlbumsQuery> call, Throwable t) {
                    getViewState().setAlbum(t.getMessage());
                }
            });
        }catch (Exception e ){
            e.printStackTrace();

        }
    }

    public Map<String,String> getRequestMap(String album){
        Map<String, String> request = new LinkedHashMap<>();
        request.put("method", "album.search");
        request.put("album", album);
        request.put("api_key", "2f2f927e08fb98c8d516d345db73f725");
        request.put("format", "json");
        return  request;
    }
}
