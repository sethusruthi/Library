package com.Books.demo.Service;
import com.Books.demo.exception.BookNotFoundException;
import com.Books.demo.model.Books;
import com.Books.demo.model.Reviews;
import com.Books.demo.repository.BookRepository;
import com.Books.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ReviewRepository reviewRepository;
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
    public Books updateBooksByBookId(int bookId, Books books) {
        Books oldBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not Found"));
        oldBook.setTitle(books.getTitle());
        oldBook.setPrice(books.getPrice());
//        oldBook.setGenre(books.getGenre());
//        oldBook.setAuthorId(books.getAuthorId());
        oldBook.setDescription(books.getDescription());
        oldBook.setRating(books.getRating());
        oldBook.setCoverImage(books.getCoverImage());

         return bookRepository.save(oldBook);
         
    }
    public List<Books> getBooksByPriceRange(Double minPrice, Double maxPrice) {
        return bookRepository.findByPriceBetween(minPrice, maxPrice);
    }
    public Books saveBook(Books book) {
        return bookRepository.save(book); // Saves or updates the book
    }

    @Override
    public Books addReviewToBook(int bookId, Reviews reviews) {
        Books books = bookRepository.findById(bookId).orElseThrow
                (()->new RuntimeException("Book not Found"));
        reviews.setBooks(books);
        reviewRepository.save(reviews);

        return books;
    }
}
