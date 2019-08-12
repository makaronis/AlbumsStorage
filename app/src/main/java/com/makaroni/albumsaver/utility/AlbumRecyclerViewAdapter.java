package com.makaroni.albumsaver.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.makaroni.albumsaver.jsonObjects.AlbumsQuery;
import com.makaroni.albumsaver.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AlbumRecyclerViewAdapter extends RecyclerView.Adapter<AlbumRecyclerViewAdapter.AlbumViewHolder> {
    private Context mContext;
    private List<AlbumsQuery.Results.Album.AlbumValues> albums;

    public AlbumRecyclerViewAdapter(Context mContext,List<AlbumsQuery.Results.Album.AlbumValues> albums) {
        this.albums = albums;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_item,parent,false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        holder.bind(albums.get(position));
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder {
        private TextView artistTextView;
        private TextView albumTextView;
        private ImageView coverImageView;
        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            artistTextView = itemView.findViewById(R.id.artist_name);
            albumTextView = itemView.findViewById(R.id.album_name);
            coverImageView = itemView.findViewById(R.id.album_cover);
        }
        public void bind (AlbumsQuery.Results.Album.AlbumValues album){
            artistTextView.setText(album.getArtist());
            albumTextView.setText(album.getName());
            String url = album.getImage().get(3).getText();
            if (!url.isEmpty()) {
                Picasso.get().load(url).placeholder(R.drawable.placeholder).into(coverImageView);
            }
        }
    }
}
