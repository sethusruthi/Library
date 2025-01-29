package com.Books.demo.controller;

import com.Books.demo.Service.AuthorService;
import com.Books.demo.model.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/author")
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

}
