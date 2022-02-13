package com.book.book.repository;

import com.book.book.dto.BookSearchDto;
import com.book.book.model.Book;

import java.util.List;
import java.util.Optional;


public interface BookRepository {

    Optional<Book> findBookById(Long id);

    void deleteBookById(Long id);

    Book save(Book book);

    List<Book> findAll();

    List<Book> filteredSearch(BookSearchDto bookSearchDto);
}


