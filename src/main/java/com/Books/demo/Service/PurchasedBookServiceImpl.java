package com.Books.demo.Service;

import com.Books.demo.model.PurchasedBooks;
import com.Books.demo.model.Users;
import com.Books.demo.repository.BookRepository;
import com.Books.demo.repository.PurchasedBooksRepository;
import com.Books.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PurchasedBookServiceImpl implements PurchasedBookService{
    @Autowired
    private PurchasedBooksRepository purchasedBookRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;
    @Override
    public List<PurchasedBooks> getPurchasedBooksByUser(Integer userId) {
        return purchasedBookRepository.findByUserId(userId);  // Use this for fetching a list
    }


    }

//    @Override
//    public PurchasedBooks getPurchasedBookById(Integer bookId) {
//        return purchasedBooksRepository.findById(bookId)
//                .orElseThrow(() -> new RuntimeException("Purchased book not found"));
//    }



