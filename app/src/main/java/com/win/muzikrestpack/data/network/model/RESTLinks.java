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

}
