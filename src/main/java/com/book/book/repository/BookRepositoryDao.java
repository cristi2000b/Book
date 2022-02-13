package com.book.book.repository;


import com.book.book.dto.BookSearchDto;
import com.book.book.model.Book;
import com.book.book.model.QBook;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
@Repository
public class BookRepositoryDao implements BookRepository{
    @Autowired
    EntityManager entityManager;

    @Override
    public Optional<Book> findBookById(Long id) {
        QBook qBook = QBook.book;
        JPAQuery<Book> query = new JPAQuery<>(entityManager);

        return Optional.ofNullable(query
                .select(qBook)
                .from(qBook)
                .where(qBook.id.eq(id))
                .fetchFirst());

    }

    @Override
    public void deleteBookById(Long id) {


    }

    @Override
    public Book save(Book book) {
        return entityManager.merge(book);
    }

    @Override
    public List<Book> findAll() {
        QBook qBook = QBook.book;
        JPAQuery<Book> query = new JPAQuery<>(entityManager);

        return query
                .select(qBook)
                .from(qBook)
                .fetch();
    }

    @Override
    public List<Book> filteredSearch(BookSearchDto bookSearchDto) {
        QBook qBook = QBook.book;
        JPAQuery<Book> query = new JPAQuery<>(entityManager);

        query.select(qBook).from(qBook);

        if(bookSearchDto.getTitle() != null){
            query.where(qBook.title.eq(bookSearchDto.getTitle()));
        }
        if(bookSearchDto.getLanguage() != null){
            query.where(qBook.language.eq(bookSearchDto.getLanguage()));
        }

        if(bookSearchDto.getAuthor() != null){
            query.where(qBook.author.eq(bookSearchDto.getAuthor()));
        }

        if(bookSearchDto.getCollection() != null){
            query.where(qBook.collection.eq(bookSearchDto.getCollection()));
        }
        if(bookSearchDto.getPublishingHouse() != null){
            query.where(qBook.publishingHouse.eq(bookSearchDto.getPublishingHouse()));
        }

        if(bookSearchDto.getYearOfLaunch() != null){
            query.where(qBook.yearOfLaunch.eq(bookSearchDto.getYearOfLaunch()));
        }

        if(bookSearchDto.getNumberOfPages() != null){
            query.where(qBook.numberOfPages.eq(bookSearchDto.getNumberOfPages()));
        }


        Path<Object> fieldPath = Expressions.path(Object.class, QBook.book, "id");
        query.orderBy(new OrderSpecifier(Order.ASC, fieldPath));
        query.limit(bookSearchDto.getPageSize()).offset((long) (bookSearchDto.pageNumber - 1) * bookSearchDto.getPageSize());

        return query.fetch();
    }
}
