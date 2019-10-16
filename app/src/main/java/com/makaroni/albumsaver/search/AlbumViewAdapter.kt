package com.makaroni.albumsaver.search


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.makaroni.albumsaver.databinding.RecyclerListItemBinding
import com.makaroni.albumsaver.jsonObjects.Album
import com.makaroni.albumsaver.search.AlbumViewAdapter.*


class AlbumViewAdapter(val onClickListener: OnClickListener) : ListAdapter<Album, AlbumViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(RecyclerListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = getItem(position)
        holder.bind(album)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(album)
        }
    }


    class AlbumViewHolder(private var binding: RecyclerListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(album: Album) {
            binding.album = album
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Album>() {
        override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem.name == newItem.name
        }
    }
    class OnClickListener(val clickListener: (album: Album) -> Unit) {
        fun onClick(album:Album) = clickListener(album)
    }
}
