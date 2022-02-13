package com.book.book.utility;

import lombok.Data;

@Data
public class SearchObject {

    private static final Integer PAGE_SIZE_LIMIT = 200;

    public Integer pageNumber = 1;
    private Integer pageSize = 25;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize > PAGE_SIZE_LIMIT ? PAGE_SIZE_LIMIT : pageSize;
    }
}
