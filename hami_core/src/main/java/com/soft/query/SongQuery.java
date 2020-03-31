package com.soft.query;

import com.soft.model.Song;

public class SongQuery extends Song {
    private Integer startNum = 0;
    private Integer pageNo;
    private Integer pageSize = 5;

    private String srname;
    private String aname;

    private Integer pageNoProtal = 1;

    public Integer getPageNoProtal() {
        return pageNoProtal;
    }

    public void setPageNoProtal(Integer pageNoProtal) {
        this.pageNoProtal = pageNoProtal;
    }

    public String getSrname() {
        return srname;
    }

    public void setSrname(String srname) {
        this.srname = srname;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "SongQuery{" +
                "startNum=" + startNum +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", srname='" + srname + '\'' +
                ", aname='" + aname + '\'' +
                '}';
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public SongQuery(Integer startNum, Integer pageNo, Integer pageSize, String tname, String srname, String aname) {
        this.startNum = startNum;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.srname = srname;
        this.aname = aname;
    }

    public SongQuery() {

    }
}
