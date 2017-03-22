package com.win.muzikrestpack.domain.model;

/**
 * Created by winhtaikaung on 20/3/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistModel {

    @SerializedName("artists")
    @Expose
    private List<Artist> artists = null;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public ArtistModel(List<Artist> artistList, Links links, Meta meta) {
        this.artists = artistList;
        this.links = links;
        this.meta = meta;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
