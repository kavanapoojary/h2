package com.example.book.Service;


import com.example.book.Model.Book;
import com.example.book.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long bookId, Book bookDetails) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null) {
            book.setBookName(bookDetails.getBookName());
            book.setBookAuthor(bookDetails.getBookAuthor());
            return bookRepository.save(book);
        }
        return null;
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
