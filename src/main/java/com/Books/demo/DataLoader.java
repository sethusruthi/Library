package com.Books.demo;

import org.springframework.context.annotation.Configuration;
import com.Books.demo.model.*;
import com.Books.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner loadData(
            LibrarianRepository librariansRepository,
            BookRepository booksRepository,
            UserRepository usersRepository,
            ReviewRepository reviewsRepository,
            UserBookPurchaseRepository userBookPurchaseRepository,
            AuthorRepository authorsRepository) {
        return args -> {
            // Creating librarians
            Librarians librarian1 = new Librarians(null, "Emily Clark", "emily.clark@example.com", null, null);
            Librarians librarian2 = new Librarians(null, "Michael Davis", "michael.davis@example.com", null, null);
            librariansRepository.saveAll(List.of(librarian1, librarian2));

            // Creating users
            Users user1 = new Users(null, "Chris Johnson", "chris.johnson@example.com", librarian1, null, null);
            Users user2 = new Users(null, "Sophia Martinez", "sophia.martinez@example.com", librarian2, null, null);
            usersRepository.saveAll(List.of(user1, user2));

            // Creating authors
            Authors author1 = new Authors(null, "George Orwell", "orwell@example.com", null);
            Authors author2 = new Authors(null, "Jane Austen", "austen@example.com", null);
            authorsRepository.saveAll(List.of(author1, author2));

            // Creating books
            Books book1 = new Books(null, "1984", 12.99, "Dystopian novel", "cover_1984.jpg", null, author1, librarian1, null);
            Books book2 = new Books(null, "Pride and Prejudice", 14.50, "Classic romance novel", "cover_pride.jpg", null, author2, librarian2, null);
            booksRepository.saveAll(List.of(book1, book2));

            // Creating reviews
            Reviews review1 = new Reviews(null, "A thought-provoking read!", 5.0, book1, user1);
            Reviews review2 = new Reviews(null, "A timeless masterpiece!", 4.8, book2, user2);
            reviewsRepository.saveAll(List.of(review1, review2));

            // Creating purchases
            UserBookPurchase purchase1 = new UserBookPurchase(null, user1, book1);
            UserBookPurchase purchase2 = new UserBookPurchase(null, user2, book2);
            userBookPurchaseRepository.saveAll(List.of(purchase1, purchase2));

        };
    }
}
