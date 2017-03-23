package com.win.muzikrestpack.domain.model;

/**
 * Created by win on 3/23/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Song {

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
    private Links links;

    /**
     * No args constructor for use in serialization
     */
    public Song() {
    }

    /**
     * @param id
     * @param title
     * @param links
     * @param href
     */
    public Song(String id, String title, String href, Links links) {
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

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

}
