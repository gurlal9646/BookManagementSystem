package com.example.Assignment4.service;

import com.example.Assignment4.entity.Book;
import com.example.Assignment4.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll().forEach(book -> bookList.add(book));
        return bookList;
    }

    public Optional<Book> getBookById(long bookId) {
        return bookRepository.findById(bookId);
    }

    public Book addNewBook(Book book) {
        book.setCreatedAt(new Date());
        return bookRepository.save(book);
    }

    public boolean deleteBookById(Long bookId) {
        Optional<Book> book = getBookById(bookId);
        if (book.isPresent()) {
            bookRepository.deleteById(bookId);
            return true;
        }
        return false;
    }

    public Optional<Book> updateBook(Book book) {

        Optional<Book> Student = getBookById(book.getId());
        if (Student.isPresent()) {
            book.setUpdatedAt(new Date());
            return Optional.ofNullable(bookRepository.save(book));
        }
        return Optional.empty();
    }
}
