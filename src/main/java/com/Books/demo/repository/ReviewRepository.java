package com.Books.demo.repository;

import com.Books.demo.model.Books;
import com.Books.demo.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Reviews, Integer> {
    List<Reviews> findByBooksLibrarianId(Integer librarianId);
    List<Reviews> findByBooksBookId(Integer bookId);
}
