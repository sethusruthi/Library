package com.Books.demo.controller;

import com.Books.demo.DTO.BulkBookUploadDTO;
import com.Books.demo.DTO.BulkUploadResponse;
import com.Books.demo.Service.BookService;
import com.Books.demo.Service.LibrarianService;
import com.Books.demo.model.Books;
import com.Books.demo.model.Librarians;
import com.Books.demo.model.Reviews;
import com.Books.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {
    @Autowired
    LibrarianService librarianService;
    @PostMapping("/bulk-upload")
    public BulkUploadResponse bulkUploadBooks(@RequestBody  List<BulkBookUploadDTO> books){
        return librarianService.bulkUploadBooks(books);
    }
    @GetMapping("/{librarianId}/users")
    public ResponseEntity<List<Users>> getManagedUsers(@PathVariable Integer librarianId){
        List<Users> users = librarianService.getManagedUsers(librarianId);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{librarianId}/books")
    public ResponseEntity<List<Books>> getManagedBooks(@PathVariable Integer librarianId) {
        List<Books> books = librarianService.getManagedBooks(librarianId);
        return ResponseEntity.ok(books);
    }
    @GetMapping("/{librarianId}/reviews")
    public ResponseEntity<List<Reviews>> getManagedBookReviews(@PathVariable Integer librarianId){
        List<Reviews> reviews = librarianService.getReviewsByLibrarian(librarianId);
        return reviews.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(reviews);



    }



}
