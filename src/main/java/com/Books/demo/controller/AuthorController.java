package com.Books.demo.controller;

import com.Books.demo.Service.AuthorService;
import com.Books.demo.model.Authors;
import com.Books.demo.model.Books;
import com.Books.demo.model.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/createAuthor")
    public Authors createAuthor(@RequestBody Authors authors){
        return authorService.createAuthor(authors);


    }
    @GetMapping("/getAllAuthors")
    public List<Authors> getAllAuthors(){
        return  authorService.getAllAuthors();
    }
    @GetMapping("/getAuthorById/{id}")
    public Authors getAuthorById(@PathVariable int id){
        return authorService.getAuthorById(id);
    }


    @PostMapping("/createBook/{authorId}/books")
    public Books createBookByAuthor(@PathVariable Integer authorId, @RequestBody Books book) {
        return authorService.createBookByAuthor(authorId, book);
    }
    @GetMapping("/{authorId}/reviews")
    public List<Reviews> getReviewsByAuthor(@PathVariable Integer authorId) {
        return authorService.getReviewsByAuthorId(authorId);
    }
}
