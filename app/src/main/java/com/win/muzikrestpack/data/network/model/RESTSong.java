package com.win.muzikrestpack.data.network.model;

/**
 * Created by win on 3/23/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RESTSong {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("links")
    @Expose
    private RESTLinks links;

    /**
     * No args constructor for use in serialization
     */
    public RESTSong() {
    }

    /**
     * @param id
     * @param title
     * @param links
     * @param href
     */
    public RESTSong(String id, String title, String href, RESTLinks links) {
        super();
        this.id = id;
        this.title = title;
        this.href = href;
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public RESTLinks getRESTLinks() {
        return links;
    }

    public void setRESTLinks(RESTLinks links) {
        this.links = links;
    }

}
