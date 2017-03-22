package com.win.muzikrestpack.domain.model;

/**
 * Created by winhtaikaung on 20/3/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artists {

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
    private Object nextPage;
    @SerializedName("previous_href")
    @Expose
    private Object previousHref;
    @SerializedName("next_href")
    @Expose
    private Object nextHref;

    public Artists(Integer page, Integer pageSize, List<Object> include, Integer pageCount, Object previousPage, Object nextPage, Object nextHref, Object previousHref) {
        this.page = page;
        this.pageSize = pageSize;
        this.include = include;
        this.pageCount = pageCount;
        this.previousPage = previousPage;
        this.nextPage = nextPage;
        this.nextHref = nextHref;
        this.previousHref = previousHref;
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

    public Object getNextPage() {
        return nextPage;
    }

    public void setNextPage(Object nextPage) {
        this.nextPage = nextPage;
    }

    public Object getPreviousHref() {
        return previousHref;
    }

    public void setPreviousHref(Object previousHref) {
        this.previousHref = previousHref;
    }

    public Object getNextHref() {
        return nextHref;
    }

    public void setNextHref(Object nextHref) {
        this.nextHref = nextHref;
    }

}
