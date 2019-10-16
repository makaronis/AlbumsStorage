package com.makaroni.albumsaver.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import com.makaroni.albumsaver.databinding.SearchFragmentBinding

import retrofit2.Response

class SearchFragment : Fragment() {
    private val viewModel : SearchViewModel by lazy {
        ViewModelProviders.of(this).get(SearchViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = SearchFragmentBinding.inflate(inflater)
        binding.setLifecycleOwner(this)
        val viewModel = ViewModelProviders.of(this)
                .get(SearchViewModel::class.java)
        binding.viewModel = viewModel
        binding.recyclerView.adapter = AlbumViewAdapter(AlbumViewAdapter.OnClickListener{
            //TODO
        })
        binding.inputEditText.setEndIconOnClickListener {
            viewModel.loadAlbums()
        }

        return binding.root
    }


}
