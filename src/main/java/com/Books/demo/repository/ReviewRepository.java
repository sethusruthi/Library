package com.Books.demo.repository;

import com.Books.demo.model.Books;
import com.Books.demo.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Reviews, Integer> {
<<<<<<< Updated upstream
=======
    List<Reviews> findByBooksLibrarianId(Integer librarianId);
    List<Reviews> findByAuthorId(Integer authorId);
>>>>>>> Stashed changes
}
