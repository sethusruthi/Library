package com.Books.demo.Service;

import com.Books.demo.model.Authors;

import java.util.List;

public interface AuthorService {
    Authors createAuthor(Authors authors);
     Authors getAuthorById(int id);
    List<Authors> getAllAuthors();
    Authors saveAuthor(Authors authors);
}
