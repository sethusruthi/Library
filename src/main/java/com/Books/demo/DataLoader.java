//package com.Books.demo;
//
//import com.Books.demo.model.*;
//import com.Books.demo.repository.*;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//
//@Configuration
//public class DataLoader {
//    @Bean
//    CommandLineRunner initDatabase(
//
//            AuthorRepository authorsRepository,
//            BookRepository booksRepository,
//            LibrarianRepository librariansRepository,
//            ReviewRepository reviewsRepository,
//            UserRepository usersRepository
//    ) {
//        return args -> {
//            // Create Librarians
//            Librarians librarian1 = new Librarians();
//            librarian1.setName("John Smith");
//            librarian1.setEmail("john.smith@library.com");
//
//            Librarians librarian2 = new Librarians();
//            librarian2.setName("Sarah Johnson");
//            librarian2.setEmail("sarah.johnson@library.com");
//
//            librariansRepository.saveAll(Arrays.asList(librarian1, librarian2));
//
//            // Create Authors
////            Authors author1 = new Authors();
////            author1.setName("George Orwell");
////            author1.setEmail("george.orwell@example.com");
////
////            Authors author2 = new Authors();
////            author2.setName("J.K. Rowling");
////            author2.setEmail("jk.rowling@example.com");
////
////            authorsRepository.saveAll(Arrays.asList(author1, author2));
//
//            // Create Books
////            Books book1 = new Books();
////            book1.setTitle("1984");
////            book1.setPrice(19.99);
////            book1.setDescription("A dystopian novel by George Orwell");
////            book1.setCoverImage("1984.jpg");
////            book1.setAuthors(author1);
////            book1.setLibrarian(librarian1);
////
////            Books book2 = new Books();
////            book2.setTitle("Animal Farm");
////            book2.setPrice(14.99);
////            book2.setDescription("An allegorical novella by George Orwell");
////            book2.setCoverImage("animal-farm.jpg");
////            book2.setAuthors(author1);
////            book2.setLibrarian(librarian1);
////
////            Books book3 = new Books();
////            book3.setTitle("Harry Potter and the Philosopher's Stone");
////            book3.setPrice(24.99);
////            book3.setDescription("The first book in the Harry Potter series");
////            book3.setCoverImage("harry-potter-1.jpg");
////            book3.setAuthors(author2);
////            book3.setLibrarian(librarian2);
////
////            booksRepository.saveAll(Arrays.asList(book1, book2, book3));
//
//            // Create Users
//            Users user1 = new Users();
//            user1.setName("Alice Cooper");
//            user1.setEmail("alice.cooper@example.com");
//            user1.setLibrarian(librarian1);
//
//            Users user2 = new Users();
//            user2.setName("Bob Dylan");
//            user2.setEmail("bob.dylan@example.com");
//            user2.setLibrarian(librarian2);
//
//            usersRepository.saveAll(Arrays.asList(user1, user2));
//
//            // Create Reviews
////            Reviews review1 = new Reviews();
////            review1.setComment("A masterpiece of dystopian fiction");
////            review1.setRating(5.0);
////            review1.setBooks(book1);
////            review1.setUser(user1);
////
////            Reviews review2 = new Reviews();
////            review2.setComment("Brilliant allegory, still relevant today");
////            review2.setRating(4.5);
////            review2.setBooks(book2);
////            review2.setUser(user1);
////
////            Reviews review3 = new Reviews();
////            review3.setComment("Magical start to an amazing series");
////            review3.setRating(5.0);
////            review3.setBooks(book3);
////            review3.setUser(user2);
////
////            reviewsRepository.saveAll(Arrays.asList(review1, review2, review3));
//        };
//    }
//}
