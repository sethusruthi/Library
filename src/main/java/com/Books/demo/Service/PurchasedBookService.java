package com.Books.demo.Service;

import com.Books.demo.model.PurchasedBooks;
import com.Books.demo.model.Users;
import com.Books.demo.repository.PurchasedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



public interface PurchasedBookService {

    List<PurchasedBooks> getPurchasedBooksByUser(Integer id);
  //  PurchasedBooks getPurchasedBookById(Integer bookId);

    //Users getUserById(Integer id);
}