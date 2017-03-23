package com.win.muzikrestpack.data.network.model;

/**
 * Created by win on 3/23/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RESTLinks_ {

    @SerializedName("songs.artist")
    @Expose
    private RESTSongsArtist RESTSongsArtist;
    @SerializedName("songs.album")
    @Expose
    private RESTSongsAlbum RESTSongsAlbum;

    /**
     * No args constructor for use in serialization
     */
    public RESTLinks_() {
    }

    /**
     * @param RESTSongsArtist
     * @param RESTSongsAlbum
     */
    public RESTLinks_(RESTSongsArtist RESTSongsArtist, RESTSongsAlbum RESTSongsAlbum) {
        super();
        this.RESTSongsArtist = RESTSongsArtist;
        this.RESTSongsAlbum = RESTSongsAlbum;
    }

    public RESTSongsArtist getRESTSongsArtist() {
        return RESTSongsArtist;
    }

    public void setRESTSongsArtist(RESTSongsArtist RESTSongsArtist) {
        this.RESTSongsArtist = RESTSongsArtist;
    }

    public RESTSongsAlbum getRESTSongsAlbum() {
        return RESTSongsAlbum;
    }

    public void setRESTSongsAlbum(RESTSongsAlbum RESTSongsAlbum) {
        this.RESTSongsAlbum = RESTSongsAlbum;
    }

}
