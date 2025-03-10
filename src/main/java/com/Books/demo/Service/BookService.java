package com.Books.demo.Service;

import com.Books.demo.DTO.BookRequestDTO;
import com.Books.demo.DTO.ReviewRequestDTO;
import com.Books.demo.model.Books;

import java.util.List;

public interface BookService {
    Books createBooks(BookRequestDTO books);
    List<Books> getAllBooks();
    Books getBookByBookId(int bookId);
    void deleteBookById(int bookId);
    Books updateBooksByBookId(int bookId, Books books);
    public List<Books> getBooksByPriceRange(Double minPrice, Double maxPrice);
    Books saveBook(Books book);
    Books addReviewToBook(int bookId, ReviewRequestDTO reviews);

}
