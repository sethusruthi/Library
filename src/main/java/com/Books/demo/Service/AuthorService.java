package com.Books.demo.Service;

import com.Books.demo.model.Authors;
import com.Books.demo.model.Books;
import com.Books.demo.model.Reviews;

import java.util.List;

public interface AuthorService {
    Authors createAuthor(Authors authors);
     Authors getAuthorById(int id);
    List<Authors> getAllAuthors();
    Authors saveAuthor(Authors authors);
    Books createBookByAuthor (int authorId, Books books);
    List<Reviews> getReviewsByAuthorId(Integer authorId);
}
