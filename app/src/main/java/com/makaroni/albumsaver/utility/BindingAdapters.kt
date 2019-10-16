package com.makaroni.albumsaver.utility

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.makaroni.albumsaver.jsonObjects.Album
import com.makaroni.albumsaver.search.AlbumViewAdapter

fun TextView.setArtistName(item: Album?){
    item?.let {

    }
}


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Album>?) {
    val adapter = recyclerView.adapter as AlbumViewAdapter
    adapter.submitList(data)
}

@BindingAdapter("albumCover")
fun bindAlbumCover(view: ImageView, url: String?){
    url?.let {
        val imgUri = url.toUri().buildUpon().scheme("https").build()
        Glide.with(view)
                .load(imgUri)
                .into(view)
    }

}