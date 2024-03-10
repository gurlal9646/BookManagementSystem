package com.example.Assignment4.restcontroller;

import com.example.Assignment4.entity.Book;
import com.example.Assignment4.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long bookId) {
        Optional<Book> book = bookService.getBookById(bookId);
        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addNewBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addNewBook(book),HttpStatus.CREATED);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") Long bookId) {
        boolean isDeleted = bookService.deleteBookById(bookId);
        if (isDeleted) {
            return new ResponseEntity<>("Book with ID: " + bookId + " deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/books")
    public ResponseEntity<String> updateBook(@RequestBody Book book) {
        Optional<Book> bok = bookService.updateBook(book);
        if (bok.isPresent()) {
            return new ResponseEntity<>("Book updated Successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
