package com.win.muzikrestpack.domain.model;

/**
 * Created by winhtaikaung on 20/3/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("artists.albums")
    @Expose
    private ArtistsAlbums artistsAlbums;
    @SerializedName("artists.songs")
    @Expose
    private ArtistsSongs artistsSongs;

    public Links(ArtistsAlbums artistsAlbums, ArtistsSongs artistsSongs) {
        this.artistsAlbums = artistsAlbums;
        this.artistsSongs = artistsSongs;
    }

    public ArtistsAlbums getArtistsAlbums() {
        return artistsAlbums;
    }

    public void setArtistsAlbums(ArtistsAlbums artistsAlbums) {
        this.artistsAlbums = artistsAlbums;
    }

    public ArtistsSongs getArtistsSongs() {
        return artistsSongs;
    }

    public void setArtistsSongs(ArtistsSongs artistsSongs) {
        this.artistsSongs = artistsSongs;
    }

}
