package com.win.muzikrestpack.data.network.model;

/**
 * Created by winhtaikaung on 20/3/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RESTMeta {

    @SerializedName("artists")
    @Expose
    private RESTArtists artists;

    @SerializedName("songs")
    @Expose
    private RESTSongs songs;

    public RESTArtists getArtists() {
        return artists;
    }

    public void setArtists(RESTArtists artists) {
        this.artists = artists;
    }

    public RESTSongs getSongs() {
        return songs;
    }

    public void setSongs(RESTSongs songs) {
        this.songs = songs;
    }

}
