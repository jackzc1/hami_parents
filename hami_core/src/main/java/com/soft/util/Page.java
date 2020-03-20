package com.soft.util;

import java.util.List;

//分页实体bean
public class Page<T> {
    //每页显示的记录数
    private Integer pageSize = 5;
    //当前页数
    private Integer pageNo = 1;
    //总记录数
    private Integer totalCount = 0;
    //总页数
    private Integer totalPage = 1;
    //开始位置
    private Integer startNum = 0;
    //查询的记录数
    private List<T> list;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        totalPage = totalCount/pageSize;
        if (totalPage == 0 || totalCount%pageSize != 0) {
            totalPage++;
        }
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartNum() {
        return (pageNo - 1) * pageSize;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Page() {

    }

    public Page(Integer pageSize, Integer pageNo, Integer totalCount, Integer totalPage, Integer startNum, List<T> list) {

        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.startNum = startNum;
        this.list = list;
    }
}
