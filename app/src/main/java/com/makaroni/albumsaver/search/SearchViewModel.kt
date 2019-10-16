package com.makaroni.albumsaver.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.makaroni.albumsaver.jsonObjects.Album
import com.makaroni.albumsaver.utility.LastfmApiStatus
import com.makaroni.albumsaver.utility.lastFmApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception


import java.util.LinkedHashMap


class SearchViewModel : ViewModel() {
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    private val _status = MutableLiveData<LastfmApiStatus>()
    val status: LiveData<LastfmApiStatus>
        get() = _status


    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>>
        get() = _albums


    fun loadAlbums(){
        coroutineScope.launch {
            var getAlbumsDeffered = lastFmApi.retrofitService.searchAlbums(
                    getRequestMap("bends")
            )
            try {
                _status.value = LastfmApiStatus.LOADING
                var albums = getAlbumsDeffered.await()
                _status.value = LastfmApiStatus.DONE
                _albums.value = albums.results.albummatches.album
            } catch(e: Exception) {
                    throw e
            }
        }
    }

    fun getRequestMap(album: String): Map<String, String> {
        val request = LinkedHashMap<String, String>()
        request["method"] = "album.search"
        request["album"] = album
        request["api_key"] = "2f2f927e08fb98c8d516d345db73f725"
        request["format"] = "json"
        return request
    }
}
