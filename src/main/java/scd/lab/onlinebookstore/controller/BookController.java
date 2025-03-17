package scd.lab.onlinebookstore.controller;

import scd.lab.onlinebookstore.entities.Book;
import scd.lab.onlinebookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @GetMapping("/priceGreaterThan/{price}")
    public ResponseEntity<List<Book>> getBooksByPrice(@PathVariable Double price) {
        return ResponseEntity.ok(bookService.getBooksByPrice(price));
    }

    @PutMapping("/updatePrice/{id}")
    public ResponseEntity<String> updatePrice(@PathVariable Long id, @RequestParam Double price) {
        bookService.updateBookPrice(id, price);
        return ResponseEntity.ok("Book price updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOutOfStockBook(@PathVariable Long id) {
        bookService.deleteOutOfStockBook(id);
        return ResponseEntity.ok("Out-of-stock book deleted successfully");
    }

    @GetMapping("/searchByTitle/{keyword}")
    public ResponseEntity<List<Book>> findBooksByTitle(@PathVariable String keyword) {
        return ResponseEntity.ok(bookService.findBooksByTitle(keyword));
    }
}

