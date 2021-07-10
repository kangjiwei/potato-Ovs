package com.potato.util;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Getter
public class PageInfoUtil<T> {

    private Integer totalPage;// 总页数
    private Integer pageNo;//当前页
    private Integer pageSize;//每页条数
    private Integer totalRecord;//总记录数
    private List<T> allRecords;

    public PageInfoUtil(List<T> allRecords, Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.allRecords = allRecords;
        this.setTotalRecord();
        this.setTotalPage();
    }

    /**
     * 获取一共多少条
     */
    private void setTotalRecord() {
        this.totalRecord = this.allRecords.size();
    }

    /**
     * 获取一共多少页
     */
    private void setTotalPage() {
        if (pageNo == 0) {
            log.debug("pageNo == 0.");
            return;
        }
        Integer pageNums = this.totalRecord / pageNo;
        //好像是
        Integer pageNumMerge = this.totalRecord % pageNo;
        this.totalPage = pageNumMerge > 0 ? pageNums + 1 : pageNums;
    }

    /**
     * 获取分页记录
     *
     * @return
     */
    public List<T> getRecordsByPage() {
        return allRecords.stream().skip((pageNo - 1) * pageSize)
                .limit(pageSize).collect(Collectors.toList());
    }


}
