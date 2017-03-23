package com.win.muzikrestpack.domain.model;

/**
 * Created by win on 3/24/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SongModel {

    @SerializedName("songs")
    @Expose
    private List<Song> songs = null;
    @SerializedName("links")
    @Expose
    private Links_ links;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    /**
     * No args constructor for use in serialization
     */
    public SongModel() {
    }

    /**
     * @param songs
     * @param links
     * @param meta
     */
    public SongModel(List<Song> songs, Links_ links, Meta meta) {
        super();
        this.songs = songs;
        this.links = links;
        this.meta = meta;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Links_ getLinks() {
        return links;
    }

    public void setLinks(Links_ links) {
        this.links = links;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
