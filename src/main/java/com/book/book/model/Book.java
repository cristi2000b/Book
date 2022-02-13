package com.book.book.model;


import com.book.book.model.enums.Category;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    private String publishingHouse;

    private String collection;

    private boolean available;

    private String language;

    private int numberOfPages;

    private int yearOfLaunch;

    private Category category;

    @Column(nullable = false, updatable = false)
    private String bookCode;

}
