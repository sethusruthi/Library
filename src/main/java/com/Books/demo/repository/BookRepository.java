package com.Books.demo.repository;

import com.Books.demo.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Books, Integer> {

    List<Books> findByPriceBetween(Double minPrice, Double maxPrice);
}
