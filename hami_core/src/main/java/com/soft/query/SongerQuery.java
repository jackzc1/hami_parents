package com.soft.query;

import com.soft.model.Songer;

public class SongerQuery extends Songer {
    private Integer startNum = 0;
    private Integer pageNo;
    private Integer pageSize = 5;
    private Integer pageNoProtal = 1;

    public Integer getPageNoProtal() {
        return pageNoProtal;
    }

    public void setPageNoProtal(Integer pageNoProtal) {
        this.pageNoProtal = pageNoProtal;
    }
    @Override
    public String toString() {
        return "SongerQuery{" +
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

    public SongerQuery(Integer startNum, Integer pageNo, Integer pageSize) {

        this.startNum = startNum;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public SongerQuery() {

    }
}
