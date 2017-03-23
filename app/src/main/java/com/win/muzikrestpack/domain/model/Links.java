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

    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("album")
    @Expose
    private String album;

    /**
     * @param artistsAlbums
     * @param artistsSongs
     */
    public Links(ArtistsAlbums artistsAlbums, ArtistsSongs artistsSongs) {
        this.artistsAlbums = artistsAlbums;
        this.artistsSongs = artistsSongs;
    }

    /**
     * @param album
     * @param artist
     */
    public Links(String artist, String album) {
        super();
        this.artist = artist;
        this.album = album;
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
