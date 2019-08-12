package com.makaroni.albumsaver.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import com.google.android.material.textfield.TextInputLayout;
import com.makaroni.albumsaver.jsonObjects.AlbumsQuery;
import com.makaroni.albumsaver.utility.AlbumRecyclerViewAdapter;
import com.makaroni.albumsaver.R;

import java.util.List;

import retrofit2.Response;

public class SearchFragment extends MvpAppCompatFragment implements SearchView {

    private TextView textView;
    private EditText albumET;
    private RecyclerView recyclerView;
    private TextInputLayout textInputCustomEndIcon;
    private AlbumRecyclerViewAdapter recyclerViewAdapter;
    @InjectPresenter
    SearchPresenter mainScreenPresenter;

    public SearchFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.search_fragment,container,false);
        albumET = rootView.findViewById(R.id.et22);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        textInputCustomEndIcon = rootView.findViewById(R.id.et2);
        textInputCustomEndIcon.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String album = albumET.getText().toString();
                mainScreenPresenter.showAlbums(mainScreenPresenter.getRequestMap(album));
            }
        });
        return rootView;
    }

    public void setAlbum(Response<AlbumsQuery> response) {
        textView.setText(response.code());
    }
    @Override
    public void setAlbum(String response) {
        textView.setText(response);
    }
    public void showError(String error){
        Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initRecyclerView(List<AlbumsQuery.Results.Album.AlbumValues> values) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewAdapter = new AlbumRecyclerViewAdapter(getContext(),values);
        recyclerView.setAdapter(recyclerViewAdapter);
    }


}
