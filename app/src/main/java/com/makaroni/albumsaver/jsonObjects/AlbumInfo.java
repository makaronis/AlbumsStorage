package com.makaroni.albumsaver.jsonObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AlbumInfo {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("artist")
    @Expose
    public String artist;
    @SerializedName("mbid")
    @Expose
    public String mbid;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("image")
    @Expose
    public List<Cover> image = null;
    @SerializedName("listeners")
    @Expose
    public String listeners;
    @SerializedName("playcount")
    @Expose
    public String playcount;
    @SerializedName("wiki")
    @Expose
    public Wiki wiki;

    public class Cover {

        @SerializedName("#text")
        @Expose
        public String text;
        @SerializedName("size")
        @Expose
        public String size;
    }
    public class Wiki {

        @SerializedName("published")
        @Expose
        public String published;
        @SerializedName("summary")
        @Expose
        public String summary;
        @SerializedName("content")
        @Expose
        public String content;
  }
}
