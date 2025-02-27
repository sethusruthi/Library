package com.Books.demo.Service;

import com.Books.demo.DTO.BulkBookUploadDTO;
import com.Books.demo.DTO.BulkUploadResponse;
import com.Books.demo.exception.ResourceNotFoundException;
import com.Books.demo.model.*;
import com.Books.demo.repository.AuthorRepository;
import com.Books.demo.repository.BookRepository;
import com.Books.demo.repository.LibrarianRepository;
import com.Books.demo.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class LibrarianService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private LibrarianRepository librarianRepository;
    @Autowired
    private ReviewRepository reviewRepository;
  
    public BulkUploadResponse bulkUploadBooks(List<BulkBookUploadDTO> books) {
        List<String> errors = new ArrayList<>();
        int successCount = 0;
        int failureCount = 0;

        for (BulkBookUploadDTO bookDTO : books) {
            try {
                if (validateBookData(bookDTO, errors)) {
                    Books book = convertToEntity(bookDTO);
                    bookRepository.save(book);
                    successCount++;
                } else {
                    failureCount++;
                }
            } catch (Exception e) {
                failureCount++;
                errors.add("Error processing book '" + bookDTO.getTitle() + "': " + e.getMessage());
            }
        }
        return BulkUploadResponse.builder()
                .totalBooks(books.size())
                .successCount(successCount)
                .failureCount(failureCount)
                .errors(errors)
                .build();

    }
    private boolean validateBookData(BulkBookUploadDTO bookDTO, List<String> errors) {
        if (bookDTO.getTitle() == null || bookDTO.getTitle().trim().isEmpty()) {
            errors.add("Title is required for book");
            return false;
        }
        if (bookDTO.getPrice() == null || bookDTO.getPrice() <= 0) {
            errors.add("Valid price is required for book: " + bookDTO.getTitle());
            return false;
        }
        if (bookDTO.getAuthorId() == null) {
            errors.add("Author ID is required for book: " + bookDTO.getTitle());
            return false;
        }
        if (bookDTO.getLibrarianId() == null) {
            errors.add("Librarian ID is required for book: " + bookDTO.getTitle());
            return false;
        }

        // Verify author exists
        Optional<Authors> author = authorRepository.findById(bookDTO.getAuthorId());
        if (author.isEmpty()) {
            errors.add("Author not found with ID: " + bookDTO.getAuthorId() + " for book: " + bookDTO.getTitle());
            return false;
        }

        // Verify librarian exists if ID is provided
        if (bookDTO.getLibrarianId() != null) {
            Optional<Librarians> librarian = librarianRepository.findById(bookDTO.getLibrarianId());
            if (librarian.isEmpty()) {
                errors.add("Librarian not found with ID: " + bookDTO.getLibrarianId() + " for book: " + bookDTO.getTitle());
                return false;
            }
        }
        return true;
    }

    private Books convertToEntity(BulkBookUploadDTO bookDTO) {
        Books book = new Books();
        book.setTitle(bookDTO.getTitle());
        book.setPrice(bookDTO.getPrice());
        book.setDescription(bookDTO.getDescription());
        book.setCoverImage(bookDTO.getCoverImage());

        // Set author
        Authors author = authorRepository.findById(bookDTO.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));
        book.setAuthors(author);

        // Set librarian if provided
        if (bookDTO.getLibrarianId() != null) {
            Librarians librarian = librarianRepository.findById(bookDTO.getLibrarianId())
                    .orElseThrow(() -> new ResourceNotFoundException("Librarian not found"));
            book.setLibrarian(librarian);
        }

        return book;
    }

    public List<Books> getManagedBooks(Integer librarianId) {
        return librarianRepository.findById(librarianId)
                .map(librarian -> {
                    log.info("Found librarian with ID: {}", librarianId);
                    return librarian.getManagedBooks();
                })
                .orElseThrow(() -> {
                    log.warn("Librarian with ID {} not found", librarianId);
                    return new ResourceNotFoundException("Librarian with ID " + librarianId + " not found");
                });
    }

    public List<Users> getManagedUsers(Integer librarianId) {
//        return librarianRepository.findById(librarianId)
//                .map(librarian -> {
//                    log.info("Found librarian with ID: {}", librarianId);
//                    return librarian.getManagedUsers();
//                })
//                .orElseGet(() -> {
//                    log.warn("Librarian with ID {} not found", librarianId);
//                    return Collections.emptyList();
//                });
        return librarianRepository.findById(librarianId)
                .map(librarian -> {
                    log.info("Found librarian with ID: {}", librarianId);
                    return librarian.getManagedUsers();
                })
                .orElseThrow(() -> {
                    log.warn("Librarian with ID {} not found", librarianId);
                    return new ResourceNotFoundException("Librarian with ID " + librarianId + " not found");
                });
    }

    public List<Reviews> getReviewsByLibrarian(Integer librarianId) {
//        return reviewRepository.findByBooksLibrarianId(librarianId);
        Optional<Librarians> librarianOpt = librarianRepository.findById(librarianId);

        if (librarianOpt.isEmpty()) {
            log.warn("Librarian with ID {} not found", librarianId);
            throw new ResourceNotFoundException("Librarian with ID " + librarianId + " not found");
        }

        List<Reviews> reviews = reviewRepository.findByBooksLibrarianId(librarianId);
        if (reviews.isEmpty()) {
            log.warn("No reviews found for ID {} ", librarianId);

            throw new ResourceNotFoundException("No reviews found for librarian with ID " + librarianId);
        }

        return reviews;

    }
}

