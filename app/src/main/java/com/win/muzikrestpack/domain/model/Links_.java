package com.win.muzikrestpack.domain.model;

/**
 * Created by win on 3/23/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links_ {

    @SerializedName("songs.artist")
    @Expose
    private SongsArtist songsArtist;
    @SerializedName("songs.album")
    @Expose
    private SongsAlbum songsAlbum;

    /**
     * No args constructor for use in serialization
     */
    public Links_() {
    }

    /**
     * @param songsArtist
     * @param songsAlbum
     */
    public Links_(SongsArtist songsArtist, SongsAlbum songsAlbum) {
        super();
        this.songsArtist = songsArtist;
        this.songsAlbum = songsAlbum;
    }

    public SongsArtist getSongsArtist() {
        return songsArtist;
    }

    public void setSongsArtist(SongsArtist songsArtist) {
        this.songsArtist = songsArtist;
    }

    public SongsAlbum getSongsAlbum() {
        return songsAlbum;
    }

    public void setSongsAlbum(SongsAlbum songsAlbum) {
        this.songsAlbum = songsAlbum;
    }

}
