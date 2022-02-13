package com.book.book.service;

import com.book.book.dto.BookSearchDto;
import com.book.book.model.Book;
import com.book.book.service.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.book.book.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        book.setBookCode(UUID.randomUUID().toString());
        return bookRepository.save(book);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findBookById(Long id) {
        return bookRepository.findBookById(id)
                .orElseThrow(() -> new BookNotFoundException("Book by id " + id + " was not found"));
    }

    public void deleteBook(Long id){
        bookRepository.deleteBookById(id);
    }

    public List<Book> filteredSearch(BookSearchDto dto) {
        return bookRepository.filteredSearch(dto);
    }

}