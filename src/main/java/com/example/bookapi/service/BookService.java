package com.example.bookapi.service;

import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private List<Book> bookList;

    public bookService() {
        bookList = new ArrayList<>();
        Book book1 = new Book(1, "Amir", "me");
        Book book2 = new Book(2, "Marie", "me");
    }

    @Override
    public Book createBook(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public List<Book> getBookList(){
        return books;
    }

    @Override
    public void deleteBooks(int id){
        Books book = getBookById(id);
        books.remove(books);
    }

    @Override
    public void updateBook(Book book){
        Book book1 = getBookById(book.getId());
        if(book1 != null){
            book1.setName(book.getName());
            book1.setAuthor(book.getAuthor());
        }
    }
/**
    public Optional<Book> getBook(Integer id) {
        Optional optional = Optional.empty();
        for (Book book : bookList) {
            if (id == book.getId()) {
                optional = Optional.of(book);
                return optional;
            }
        }

    }
 **/

}
