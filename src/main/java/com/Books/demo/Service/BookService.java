package com.Books.demo.Service;

import com.Books.demo.model.Books;
import com.Books.demo.model.Reviews;

import java.util.List;

public interface BookService {
    Books createBooks(Books books);
    List<Books> getAllBooks();
    Books getBookByBookId(int bookId);
    void deleteBookById(int bookId);
    Books updateBooksByBookId(int bookId, Books books);
    public List<Books> getBooksByPriceRange(Double minPrice, Double maxPrice);
    Books saveBook(Books book);
    Books addReviewToBook(int bookId, Reviews reviews);
     List<Reviews> getReviewsByAuthor(Integer authorId);
    Books uploadBooks(Books book, Integer authorId);
}
