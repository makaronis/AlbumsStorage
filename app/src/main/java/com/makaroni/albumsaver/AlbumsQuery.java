package com.makaroni.albumsaver;
    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

    import java.util.List;
public class AlbumsQuery {

    @SerializedName("results")
    @Expose
    public Results results;

    public Results getResults() {
        return results;
    }


    public class Results {

        @SerializedName("albummatches")
        @Expose
        public Album albummatches;

        public Album getAlbummatches() {
            return albummatches;
        }

            public class Album {
                @SerializedName("album")
                @Expose
                public List<AlbumValues> albumValues = null;

                public List<AlbumValues> getAlbumValues() {
                    return albumValues;
                }

                public class AlbumValues {
                    @SerializedName("name")
                    @Expose
                    public String name;
                    @SerializedName("artist")
                    @Expose
                    public String artist;
                    @SerializedName("url")
                    @Expose
                    public String url;
                    @SerializedName("image")
                    @Expose
                    public List<Covers> image = null;

                    public String getName() {
                        return name;
                    }

                    public String getArtist() {
                        return artist;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public List<Covers> getImage() {
                        return image;
                    }

                    public class Covers {
                        @SerializedName("#text")
                        @Expose
                        public String text;
                        @SerializedName("size")
                        @Expose
                        public String size;

                        public String getText() {
                            return text;
                        }

                        public String getSize() {
                            return size;
                        }

                    }
                }
            }
        }
    }

