package com.Books.demo.repository;

import com.Books.demo.model.Authors;
import com.Books.demo.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Authors, Integer> {
}
