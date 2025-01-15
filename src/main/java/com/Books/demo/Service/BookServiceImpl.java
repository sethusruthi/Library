package com.Books.demo.Service;
import com.Books.demo.exception.BookNotFoundException;
import com.Books.demo.model.Books;
import com.Books.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;
    @Override
    public Books createBooks(Books books) {

        return bookRepository.save(books);
    }

    @Override
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Books getBookByBookId(int bookId) {
        if (bookRepository.findById(bookId).isEmpty())
            throw new BookNotFoundException("Requested Book does not exist");
        return bookRepository.findById(bookId).get();
    }

    @Override
    public void deleteBookById(int bookId) {
        bookRepository.deleteById(bookId);
    }


    @Override
    public Books updateBooksByBookId(Books books) {
        Books oldBook = getBookByBookId(books.getBookId());
        oldBook.setBookName(books.getBookName());
        oldBook.setPrice(books.getPrice());
        oldBook.setGenre(books.getGenre());
        oldBook.setAuthorId(books.getAuthorId());
        return bookRepository.save(oldBook);
    }
    public List<Books> getBooksByPriceRange(Double minPrice, Double maxPrice) {
        return bookRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
