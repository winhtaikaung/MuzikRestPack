package com.win.muzikrestpack.data.network.model;

/**
 * Created by win on 3/23/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RESTSongsArtist {

    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("type")
    @Expose
    private String type;

    /**
     * No args constructor for use in serialization
     */
    public RESTSongsArtist() {
    }

    /**
     * @param type
     * @param href
     */
    public RESTSongsArtist(String href, String type) {
        super();
        this.href = href;
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
