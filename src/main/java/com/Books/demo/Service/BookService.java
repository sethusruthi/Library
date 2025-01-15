package com.Books.demo.Service;

import com.Books.demo.model.Books;

import java.util.List;

public interface BookService {
    Books createBooks(Books books);
    List<Books> getAllBooks();
    Books getBookByBookId(int bookId);
    void deleteBookById(int bookId);
    Books updateBooksByBookId(Books books);
    public List<Books> getBooksByPriceRange(Double minPrice, Double maxPrice);


}
