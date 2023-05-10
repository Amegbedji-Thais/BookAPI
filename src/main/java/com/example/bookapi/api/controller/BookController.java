package com.example.bookapi.api.controller;

import com.example.bookapi.api.model.Book;
import com.example.bookapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api")
public class BookController {
    private BookService bookService;
    @Autowired
    public BookController(BookService bookService){

        this.bookService = bookService;
    }

    //@ApiOperation(value="create a new book")
    @PostMapping("/books")
   // @ApiResponses(value = {@ApiResponse(code = 201, message = "Book successfully created")})
    @ResponseStatus(HttpStatus.CREATED)

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity getBookById(@PathVariable("id") String id) {
        Book book = bookService.findBookById(id);
        if (!book.isPresent()) {
            return null;
        } else {
            return (Book) book.get();
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
    }

    @GetMapping("/books/{name}")
    public ResponseEntity getBookByName(@PathVariable("name") String name) {
        Book book = bookService.findBookByName(name);
        if (book.isPresent()) {
            return (Book) book.get();
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        else{
            return null;
        }

    }

    @GetMapping("/{author}")
    public ResponseEntity getBookByAuthor(@PathVariable("author") String author) {
        List<Book> books = bookService.findListBooksByAuthor();
        if (books != null) {
            return (Books) book.get();
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
        else{
            return null;
        }
    }

    @PutMapping
    public ResponseEntity updateBook(@RequestBody Book book){
        if(BookService.findBookById(book.isPresent()){
            bookService.updateBook(book);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
    }

    @DeleteMapping
    public ResponseEntity deleteBooks(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        if(book!=null){
            bookService.deleteBook(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/book")
    public Book getBook(@RequestParam Integer id){
        Optional book = bookService.getBook(id);
        if (book.isPresent()){
            return (Book) book.get();
        }
        return null;

    }

}
