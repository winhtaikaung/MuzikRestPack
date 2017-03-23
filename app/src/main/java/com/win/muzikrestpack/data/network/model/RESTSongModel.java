package com.win.muzikrestpack.data.network.model;

/**
 * Created by win on 3/24/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RESTSongModel {

    @SerializedName("songs")
    @Expose
    private List<RESTSong> RESTSongs = null;
    @SerializedName("links")
    @Expose
    private RESTLinks_ links;
    @SerializedName("meta")
    @Expose
    private RESTMeta meta;

    /**
     * No args constructor for use in serialization
     */
    public RESTSongModel() {
    }

    /**
     * @param RESTSongs
     * @param links
     * @param meta
     */
    public RESTSongModel(List<RESTSong> RESTSongs, RESTLinks_ links, RESTMeta meta) {
        super();
        this.RESTSongs = RESTSongs;
        this.links = links;
        this.meta = meta;
    }

    public List<RESTSong> getRESTSongs() {
        return RESTSongs;
    }

    public void setRESTSongs(List<RESTSong> RESTSongs) {
        this.RESTSongs = RESTSongs;
    }

    public RESTLinks_ getLinks() {
        return links;
    }

    public void setLinks(RESTLinks_ links) {
        this.links = links;
    }

    public RESTMeta getRESTMeta() {
        return meta;
    }

    public void setRESTMeta(RESTMeta meta) {
        this.meta = meta;
    }

}
