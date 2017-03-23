package com.win.muzikrestpack.data.network.model;

/**
 * Created by winhtaikaung on 20/3/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RESTLinks {

    @SerializedName("artists.albums")
    @Expose
    private RESTArtistsAlbums artistsAlbums;
    @SerializedName("artists.songs")
    @Expose
    private RESTArtistsSongs artistsSongs;

    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("album")
    @Expose
    private String album;

    public RESTArtistsAlbums getArtistsAlbums() {
        return artistsAlbums;
    }

    public void setArtistsAlbums(RESTArtistsAlbums artistsAlbums) {
        this.artistsAlbums = artistsAlbums;
    }

    public RESTArtistsSongs getArtistsSongs() {
        return artistsSongs;
    }

    public void setArtistsSongs(RESTArtistsSongs artistsSongs) {
        this.artistsSongs = artistsSongs;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

}
