package com.Books.demo.repository;

import com.Books.demo.model.UserBookPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBookPurchaseRepository extends JpaRepository<UserBookPurchase, Integer> {
    List<UserBookPurchase> findUserById(int userId);
}
