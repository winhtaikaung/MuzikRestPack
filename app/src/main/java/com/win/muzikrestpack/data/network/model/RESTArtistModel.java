package com.win.muzikrestpack.data.network.model;

/**
 * Created by winhtaikaung on 20/3/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RESTArtistModel {

    @SerializedName("artists")
    @Expose
    private List<RESTArtist> artists = null;
    @SerializedName("links")
    @Expose
    private RESTLinks links;
    @SerializedName("meta")
    @Expose
    private RESTMeta meta;

    public List<RESTArtist> getArtists() {
        return artists;
    }

    public void setArtists(List<RESTArtist> artists) {
        this.artists = artists;
    }

    public RESTLinks getLinks() {
        return links;
    }

    public void setLinks(RESTLinks links) {
        this.links = links;
    }

    public RESTMeta getMeta() {
        return meta;
    }

    public void setMeta(RESTMeta meta) {
        this.meta = meta;
    }

}
