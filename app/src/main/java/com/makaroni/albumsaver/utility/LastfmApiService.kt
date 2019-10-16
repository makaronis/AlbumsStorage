package com.makaroni.albumsaver.utility

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.makaroni.albumsaver.jsonObjects.AlbumInfo

import com.makaroni.albumsaver.jsonObjects.ResponceData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap


private var BASE_URL = "http://ws.audioscrobbler.com/"
interface LastFmApiService {
    @GET("2.0")
    fun searchAlbums(@QueryMap call: Map<String, String>):
            Deferred<ResponceData>

    @GET("2.0")
    fun getAlbumInfo(@QueryMap call: Map<String, String>): Call<AlbumInfo>
}

private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()


private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()

object lastFmApi {
    val retrofitService : LastFmApiService by lazy {
        retrofit.create(LastFmApiService::class.java)
    }
}

enum class LastfmApiStatus {
    LOADING,ERROR,DONE
}