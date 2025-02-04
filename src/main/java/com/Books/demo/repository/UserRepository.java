package com.Books.demo.repository;

import com.Books.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Integer> {
    //Optional<Users> findById(Integer id);
}
