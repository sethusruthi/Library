package com.Books.demo.repository;

import com.Books.demo.model.Librarians;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<Librarians, Integer> {
}
