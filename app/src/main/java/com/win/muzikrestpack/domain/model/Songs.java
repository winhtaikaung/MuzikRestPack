package com.win.muzikrestpack.domain.model;

/**
 * Created by win on 3/23/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Songs {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("page_size")
    @Expose
    private Integer pageSize;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("include")
    @Expose
    private List<Object> include = null;
    @SerializedName("page_count")
    @Expose
    private Integer pageCount;
    @SerializedName("previous_page")
    @Expose
    private Object previousPage;
    @SerializedName("next_page")
    @Expose
    private Integer nextPage;
    @SerializedName("previous_href")
    @Expose
    private Object previousHref;
    @SerializedName("next_href")
    @Expose
    private String nextHref;

    /**
     * No args constructor for use in serialization
     */
    public Songs() {
    }

    /**
     * @param pageCount
     * @param nextPage
     * @param count
     * @param nextHref
     * @param page
     * @param previousHref
     * @param pageSize
     * @param previousPage
     * @param include
     */
    public Songs(Integer page, Integer pageSize, Integer count, List<Object> include, Integer pageCount, Object previousPage, Integer nextPage, Object previousHref, String nextHref) {
        super();
        this.page = page;
        this.pageSize = pageSize;
        this.count = count;
        this.include = include;
        this.pageCount = pageCount;
        this.previousPage = previousPage;
        this.nextPage = nextPage;
        this.previousHref = previousHref;
        this.nextHref = nextHref;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Object> getInclude() {
        return include;
    }

    public void setInclude(List<Object> include) {
        this.include = include;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Object getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(Object previousPage) {
        this.previousPage = previousPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Object getPreviousHref() {
        return previousHref;
    }

    public void setPreviousHref(Object previousHref) {
        this.previousHref = previousHref;
    }

    public String getNextHref() {
        return nextHref;
    }

    public void setNextHref(String nextHref) {
        this.nextHref = nextHref;
    }

}
