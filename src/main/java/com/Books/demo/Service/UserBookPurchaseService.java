package com.Books.demo.Service;

import com.Books.demo.model.Books;
import com.Books.demo.model.UserBookPurchase;
import com.Books.demo.repository.UserBookPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserBookPurchaseService {
    @Autowired
    private UserBookPurchaseRepository userBookPurchaseRepository;

    public List<Books> getBooksPurchasedByUser(Integer userId) {
        List<UserBookPurchase> purchases = userBookPurchaseRepository.findUserById(userId);
        return purchases.stream().map(UserBookPurchase::getBook).collect(Collectors.toList());
    }

}
