package scd.lab.onlinebookstore.service;

import scd.lab.onlinebookstore.entities.Book;
import scd.lab.onlinebookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooksByPrice(Double price) {
        return bookRepository.findBooksByPriceGreaterThan(price);
    }

    @Transactional
    public void updateBookPrice(Long id, Double price) {
        bookRepository.updateBookPrice(id, price);
    }

    @Transactional
    public void deleteOutOfStockBook(Long id) {
        bookRepository.deleteOutOfStockBook(id);
    }

    public List<Book> findBooksByTitle(String keyword) {
        return bookRepository.findBooksByTitle(keyword);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
}

