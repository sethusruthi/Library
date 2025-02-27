package com.Books.demo.controller;

import com.Books.demo.Service.UserBookPurchaseService;
import com.Books.demo.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookPurchases")
public class UserBookPurchaseController {
    @Autowired
     UserBookPurchaseService userBookPurchaseService;

    @GetMapping("/userPurchase/{userId}")
    public List<Books> getBooksPurchasedByUser(@PathVariable Integer userId) {
        return userBookPurchaseService.getBooksPurchasedByUser(userId);
    }
}
