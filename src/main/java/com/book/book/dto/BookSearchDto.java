package com.book.book.dto;

import com.book.book.model.enums.Category;
import com.book.book.utility.SearchObject;
import lombok.Data;

@Data
public class BookSearchDto extends SearchObject {
    private String title;
    private String author;
    private String publishingHouse;
    private String collection;
    private Boolean available;
    private String language;
    private Integer numberOfPages;
    private Integer yearOfLaunch;
    private String bookCode;
    private Category category;
}
