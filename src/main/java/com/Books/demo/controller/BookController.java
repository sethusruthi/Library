package com.Books.demo.controller;

import com.Books.demo.Service.BookService;
import com.Books.demo.Service.PurchasedBookService;
import com.Books.demo.model.Books;
import com.Books.demo.model.PurchasedBooks;
import com.Books.demo.model.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    private PurchasedBookService purchasedBookService;

    @PostMapping("/createBook")
    public Books createBooks(@RequestBody Books books){
        return bookService.createBooks(books);
    }
    @GetMapping("/getAllBooks")
    public List<Books> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/getBookById/{bookId}")
    public Books getBookById(@PathVariable int bookId){
        return bookService.getBookByBookId(bookId);
    }
    @DeleteMapping("/deleteBookById/{bookId}")
    public void deleteBookById(@PathVariable int bookId){
        bookService.deleteBookById(bookId);
    }
    @PutMapping("/updateBookById/{bookId}")
    public Books updateBookById(@PathVariable int bookId,@RequestBody Books books){
        return bookService.updateBooksByBookId(bookId,books);
    }
    @GetMapping("/filter/{minPrice}/{maxPrice}")
    public List<Books> getBooksByPriceRange(@PathVariable Double minPrice,
                                            @PathVariable Double maxPrice){
        return bookService.getBooksByPriceRange(minPrice, maxPrice);
    }
    @PostMapping("/addReviewToBook/{bookId}")
    public Books postReview(@PathVariable int bookId, @RequestBody Reviews reviews) {
        return bookService.addReviewToBook(bookId, reviews);
    }

    @GetMapping("/author/reviews/{authorId}")
    public ResponseEntity<List<Reviews>> getAuthorReviews(@PathVariable Integer authorId) {
        return ResponseEntity.ok(bookService.getReviewsByAuthor(authorId));
    }


    @GetMapping("/purchasedBooks/{userId}")
    public ResponseEntity<List<PurchasedBooks>> getPurchasedBooks(@PathVariable Integer userId) {
        List<PurchasedBooks> purchasedBooks = purchasedBookService.getPurchasedBooksByUser(userId);
        return ResponseEntity.ok(purchasedBooks);
    }

    @PostMapping("/author/upload-book")
    public ResponseEntity<Books> uploadBook(@RequestBody Books book, @RequestParam Integer authorId) {
        Books savedBook = bookService.uploadBooks(book, authorId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

}
