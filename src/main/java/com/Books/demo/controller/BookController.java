package com.Books.demo.controller;
import com.Books.demo.DTO.BookRequestDTO;
import com.Books.demo.DTO.ReviewRequestDTO;
import com.Books.demo.Service.BookService;
import com.Books.demo.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/books")
@Validated
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/createBook")
    public Books createBooks(@Valid @RequestBody BookRequestDTO bookRequestDTO){
        return bookService.createBooks(bookRequestDTO);
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
    @PostMapping("/{bookId}/reviews")
    public Books postReview(@PathVariable int bookId, @Valid @RequestBody ReviewRequestDTO reviewRequestDTO) {
        return bookService.addReviewToBook(bookId, reviewRequestDTO);
    }

}
