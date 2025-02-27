package com.Books.demo.Service;

import com.Books.demo.model.Authors;
import com.Books.demo.model.Books;
import com.Books.demo.model.Reviews;
import com.Books.demo.repository.AuthorRepository;
import com.Books.demo.repository.BookRepository;
import com.Books.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Authors createAuthor(Authors authors) {
        return authorRepository.save(authors);
    }

    @Override
    public Authors getAuthorById(int id)   {
        return authorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Author not found with ID: " + id)
        );

    }

    @Override
    public List<Authors> getAllAuthors() {
        return authorRepository.findAll();
    }



    @Override
    public Authors saveAuthor(Authors authors) {
        return authorRepository.save(authors);
    }

    @Override
    public Books createBookByAuthor(int authorId, Books books) {
        Optional<Authors> authorOptional = authorRepository.findById(authorId);

        if (authorOptional.isEmpty()) {
            throw new RuntimeException("Author not found with ID: " + authorId);
        }
        Authors author = authorOptional.get();
        books.setAuthors(author);
        return bookRepository.save(books);
    }

    public List<Reviews> getReviewsByAuthorId(Integer authorId) {
        List<Books> books = bookRepository.findByAuthorsId(authorId);
        List<Reviews> reviews = new ArrayList<>();

        if (books != null && !books.isEmpty()) {
            for (Books book : books) {
                if (book != null && book.getBookId() != null) {
                    reviews.addAll(reviewRepository.findByBooksBookId(book.getBookId()));
                }
            }
        }

        return reviews;
    }

}
