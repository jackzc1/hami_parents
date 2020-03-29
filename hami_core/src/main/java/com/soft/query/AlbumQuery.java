package com.soft.query;

import com.soft.model.Album;

public class AlbumQuery extends Album {

    private Integer startNum = 0;
    private Integer pageNo;
    private Integer pageSize = 5;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public AlbumQuery(Integer startNum, Integer pageNo, Integer pageSize) {

        this.startNum = startNum;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "AlbumQuery{" +
                "startNum=" + startNum +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public AlbumQuery() {

    }
}
