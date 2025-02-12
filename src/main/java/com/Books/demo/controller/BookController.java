package com.Books.demo.controller;

import com.Books.demo.Service.BookService;
import com.Books.demo.model.Books;
import com.Books.demo.model.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookService bookService;

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

}
