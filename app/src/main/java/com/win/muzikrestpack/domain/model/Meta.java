package com.win.muzikrestpack.domain.model;

/**
 * Created by winhtaikaung on 20/3/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("artists")
    @Expose
    private Artists artists;

    @SerializedName("songs")
    @Expose
    private Songs songs;

    public Meta(Artists artists) {
        this.artists = artists;
    }

    public Meta(Songs songs) {
        super();
        this.songs = songs;
    }

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    public Songs getSongs() {
        return songs;
    }

    public void setSongs(Songs songs) {
        this.songs = songs;
    }


}
