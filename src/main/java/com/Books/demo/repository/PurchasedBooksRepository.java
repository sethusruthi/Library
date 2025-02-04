package com.Books.demo.repository;

import com.Books.demo.model.PurchasedBooks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PurchasedBooksRepository extends JpaRepository<PurchasedBooks,Integer> {
   ;
    List<PurchasedBooks> findByUserId(Integer userId);  // This is for getting a list of purchased books by userId
    Optional<PurchasedBooks> findById(Integer bookId);  // This is for getting a single purchased book by its ID
}
