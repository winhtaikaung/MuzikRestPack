package com.win.muzikrestpack.presentation.ui.base;

import java.util.List;

/**
 * Created by win on 3/26/17.
 */

public class SectionView {
    private int HORIZONTAL = 100;
    private int VERTICAL = 200;

    private Object object;
    private List<Object> listData;
    private boolean isList;
    private int orientation;


    /**
     *
     * @param listData
     * @param isList
     */
    public SectionView(Object listData, boolean isList) {
        this.object = listData;
        this.isList = isList;

    }

    public List<Object> getListData() {
        return listData;
    }


    public void setListData(List<Object> listData) {
        this.listData = listData;
    }

    public boolean isList() {
        return isList;
    }

    public void setList(boolean list) {
        isList = list;
    }

    public int getOrientation() {
        if (orientation == 100 || orientation == 200) {
            return orientation;
        } else {
            // It will return Horizontal
            return 200;
        }
    }

    public void setOrientation(int orientation) {
        if (orientation == 100 || orientation == 200) {
            this.orientation = orientation;
        } else {
            this.orientation = 200;
        }
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
