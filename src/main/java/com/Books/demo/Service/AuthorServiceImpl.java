package com.Books.demo.Service;

import com.Books.demo.model.Authors;
import com.Books.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorRepository authorRepository;

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
}
